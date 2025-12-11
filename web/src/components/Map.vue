<script setup >
import { Map, MapStyle, Marker, config, Popup } from '@maptiler/sdk';
import { shallowRef, onMounted, onUnmounted, markRaw } from 'vue';
import '@maptiler/sdk/dist/maptiler-sdk.css';

import { getStationPageByMap } from '@/api'

const emits = defineEmits(['change'])


const mapContainer = shallowRef(null);
const map = shallowRef(null);

onMounted(async () => {
  config.apiKey = '5dPy611BtAufNGOyAaVt';

  const initialState = { lng: 139.753, lat: 35.6844, zoom: 1 };

  const res = await getStationPageByMap({});

  map.value = markRaw(new Map({
    container: mapContainer.value,
    style: MapStyle.SATELLITE,
    center: [initialState.lng, initialState.lat],
    zoom: initialState.zoom
  }));



  map.value.on('load', async () => {
    map.value.addSource('places', {
      'type': 'geojson',
      'data': {
        'type': 'FeatureCollection',
        features: res.map((item, index) => {
          return {
            id: index,
            'type': 'Feature',
            'properties': {
              'description': item,
              'icon': 'green-dot',
            },
            'geometry': {
              'type': 'Point',
              'coordinates': [item.geoLong, item.geoLat]
            }
          }
        })
      }
    });

    // Create an image from SVG


    function svgStringToImageSrc (svgString) {
      return 'data:image/svg+xml;charset=utf-8,' + encodeURIComponent(svgString)
    }

    const pin1 = `<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 10 10" width="10" height="10"><circle cx="5" cy="5" r="5" fill="#69db7c"/></svg>`;

    const svgPinImage = new Image(6, 6);

    svgPinImage.onload = () => {
      map.value.addImage('pin1', svgPinImage)
    }

    svgPinImage.src = svgStringToImageSrc(pin1);


    map.value.addLayer({
      'id': 'places',
      'type': 'symbol',
      'source': 'places',
      'layout': {
        'icon-image': 'pin1',
        'icon-overlap': 'always',
        'icon-size': 1
      }
    });

    map.value.on('click', 'places', function (e) {
      const coordinates = e.features[0].geometry.coordinates.slice();
      const description = e.features[0].properties.description;
      const json = JSON.parse(description)

      // 移动地图中心点到点击位置
      map.value.flyTo({
        center: coordinates,
        zoom: 5,
        speed: 0.8
      });

      emits('change', json)

      while (Math.abs(e.lngLat.lng - coordinates[0]) > 180) {
        coordinates[0] += e.lngLat.lng > coordinates[0] ? 360 : -360;
      }

      console.log(coordinates);

      // Populate the popup and set its coordinates
      // based on the feature found.
      popup.setLngLat(coordinates).setHTML(`<div>${json.name}</div>`).addTo(map.value);
    });

    // Create a popup, but don't add it to the map yet.
    const popup = new Popup({
      closeButton: false,
      closeOnClick: false
    });

    // map.value.on('mouseenter', 'places', function (e) {
    //   // Change the cursor style as a UI indicator.
    //   map.value.getCanvas().style.cursor = 'pointer';
    //
    //   const coordinates = e.features[0].geometry.coordinates.slice();
    //   const description = e.features[0].properties.description;
    //
    //   const json = JSON.parse(description)
    //
    //   // Ensure that if the map is zoomed out such that multiple
    //   // copies of the feature are visible, the popup appears
    //   // over the copy being pointed to.
    //   while (Math.abs(e.lngLat.lng - coordinates[0]) > 180) {
    //     coordinates[0] += e.lngLat.lng > coordinates[0] ? 360 : -360;
    //   }
    //
    //   console.log(coordinates);
    //
    //   // Populate the popup and set its coordinates
    //   // based on the feature found.
    //   popup.setLngLat(coordinates).setHTML(`<div>${json.name}</div>`).addTo(map.value);
    // });


    // map.value.on('mousemove', 'places', function (e) {
    //   console.log(e);
    //   if (e.features.length > 0) {
    //     // map.value.setFeatureState({
    //     //   source: 'places',
    //     //   sourceLayer: 'my-source-layer',
    //     //   id: e.features[0].id,
    //     // }, {
    //     //   hover: true
    //     // });
    //   }
    // });

  })



})

onUnmounted(() => {
  map.value?.remove();
})
</script>

<template>
  <div class="map-wrap">
    <div class="map" ref="mapContainer"></div>
  </div>
</template>

<style scoped lang="less">
.map-wrap {
  position: relative;
  width: 100%;
  height: calc(100vh - 77px); /* calculate height of the screen minus the heading */
}

.map {
  position: absolute;
  width: 100%;
  height: 100%;
}
</style>
