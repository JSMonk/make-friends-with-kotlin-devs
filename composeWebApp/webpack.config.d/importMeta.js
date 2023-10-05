const webpack = require("webpack")

config.module.rules.push({
    test: /\.js$/,
    exclude: /node_modules/,
    use: [{ loader: 'import-meta-loader' }]
})

config.plugins.push(
    new webpack.EnvironmentPlugin({
        VITE_API_URL: "http://localhost:9090"
    })
)