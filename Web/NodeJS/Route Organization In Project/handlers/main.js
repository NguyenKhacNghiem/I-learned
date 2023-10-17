// File này sẽ là 1 module chứa các handler (callback functions) cho các middleware
module.exports.index = (req, res) => {
    res.render("index");
}

module.exports.about = (req, res) => {
    res.render("about");
}

module.exports.contact = (req, res) => {
    res.render("contact");
}