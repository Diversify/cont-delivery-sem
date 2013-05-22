//Set the require.js configuration for the application.
require.config({
    //Initialize the application with the main application file
    deps:["vote"],

    baseUrl: "js",

    paths: {
        //Libraries
        jquery: "libs/jquery.min",
        jqueryQR: "libs/jquery.qrcode.min",
        bootstrap: "libs/bootstrap.min",
        json: "libs/json3.min"
    },

    shim: {
        bootstrap: ["jquery"],

        jqueryQR: ["jquery"]

    }
});