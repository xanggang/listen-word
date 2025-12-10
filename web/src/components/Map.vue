<script setup >
import { Map, MapStyle, Marker, config } from '@maptiler/sdk';
import { shallowRef, onMounted, onUnmounted, markRaw } from 'vue';
import '@maptiler/sdk/dist/maptiler-sdk.css';

import { getStationPageByMap } from '@/api'



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

    const hoverPin = `<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 10 10" width="10" height="10"><circle cx="5" cy="5" r="5" fill="#000000"/></svg>`;

    const svgPinImage = new Image(4, 4);

    svgPinImage.onload = () => {
      map.value.addImage('pin1', svgPinImage)
    }

    svgPinImage.src = svgStringToImageSrc(pin1);

    const svgHoverPinImage = new Image(4, 4);

    svgHoverPinImage.onload = () => {
      map.value.addImage('hoverPin', svgHoverPinImage)
    }

    svgHoverPinImage.src = svgStringToImageSrc(hoverPin);



    map.value.addLayer({
      'id': 'places',
      'type': 'symbol',
      'source': 'places',
      // 'paint': {
      //   'fill-color': "#D3DBEC",
      //   'fill-opacity': 0.8,
      //   'fill-outline-color': "rgba(255, 255, 255, 1)"
      // },
      'layout': {
        'icon-image': 'pin1',
        'icon-overlap': 'always',
        'icon-size': 1
      }
    });

    map.value.on('click', 'places', function (e) {
      const coordinates = e.features[0].geometry.coordinates.slice();
      const description = e.features[0].properties.description;

      console.log(coordinates);
      console.log(description);
    });

    map.value.on('mousemove', 'places', function (e) {
      console.log(e);
      if (e.features.length > 0) {
        // map.value.setFeatureState({
        //   source: 'places',
        //   sourceLayer: 'my-source-layer',
        //   id: e.features[0].id,
        // }, {
        //   hover: true
        // });
      }
    });

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
