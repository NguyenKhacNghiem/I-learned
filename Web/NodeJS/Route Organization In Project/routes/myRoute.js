const main = require("../handlers/main");

module.exports = (app) => {
    app.get("/", main.index);
    app.get("/about", main.about);
    app.get("/contact", main.contact);
}