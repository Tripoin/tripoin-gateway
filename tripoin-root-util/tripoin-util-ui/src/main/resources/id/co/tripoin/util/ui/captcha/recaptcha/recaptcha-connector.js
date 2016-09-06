window.id_co_tripoin_util_ui_captcha_recaptcha_ReCaptcha =
function() {
    var element = this.getElement();

    this.onStateChange = function() {
        var state = this.getState();
        var html, elementId;
        if (state.customHtml) {
            html = state.customHtml;
            elementId = null;
        } else {
            html = '<div id="recaptcha_div"></div>';
            elementId = "recaptcha_div";
        }
        element.innerHTML = html;
        Recaptcha.create(state.publicKey, elementId, state.options);
    };
    
    this.reload = function() {
        Recaptcha.reload();
    };

    var connector = this;
    element.onchange = function() {
        connector.responseChanged(Recaptcha.get_challenge(), Recaptcha.get_response());
    };
};