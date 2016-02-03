function getUrlValue(varName) {
    var split = $(location).attr('href').split('?');
    var value = '';
    if (split.length === 2) {
        split = split[1].split('&');
        for (var i = 0; i < split.length; i+=1) {
            var keyValue = split[i].split('=');
            if (keyValue.length === 2 && keyValue[0] === varName) {
                value = keyValue[1];
                break;
            }
        }
    }
    return value;
}