import postCssPxToRem from 'postcss-pxtorem'
import postcssPresetEnv from 'postcss-preset-env'
import autoprefixer from 'autoprefixer'


export default function (opts = { remOpts: {}}) {
	return {
		plugins: [
			postcssPresetEnv({}), // 使用最新的 CSS 特性
			autoprefixer({}), // 自动添加浏览器前缀
			postCssPxToRem({
				rootValue: 100, // 1rem = 16px
				propList: ['*'],
				...opts.remOpts
			})
		]
	}
}
