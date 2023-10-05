const webpack = require("webpack")

config.module.rules.push({
    test: /\.mjs$/,
    exclude: /node_modules/,
    use: [{ loader: 'import-meta-loader' }]
})

config.plugins.push(
    new webpack.EnvironmentPlugin({
        VITE_API_URL: "http://localhost:9090"
    })
)