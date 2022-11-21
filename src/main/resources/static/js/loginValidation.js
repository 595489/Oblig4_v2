const phoneRule = new RegExp('^\\d{8}$');

// const passRuleMin = new RegExp('/^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,}$/'); // Fant denne som jeg tror er bra. Hvis denne matcher blir feltet orange
// const passRuleGood = new RegExp('/^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{16,}$/'); // Samme som over, men med 16 tegn. Hvis denne matcher blir feltet grønt
// const passRuleMin = new RegExp('/^(?=.+\\d)(?=.+[a-z])(?=.+[A-Z]).{8,}$/'); // Mulig denne er bedre. Skal tillate tegn og mellomrom, burde teste begge, orange
// const passRuleGood = new RegExp('/^(?=.+\\d)(?=.+[a-z])(?=.+[A-Z]).{16,}$/'); // Mulig denne er bedre. Skal tillate tegn og mellomrom, burde teste begge, grønt
const passRuleMin = new RegExp("^.{4,}$");
const passRuleGood = new RegExp("^.{8,}$");

function mobilSjekk() {
    let mobil = mob.value;
    if (mob.className.includes("border")){
        if (mobil.match(phoneRule)) {
            mob.className = mob.className.replace(" red-border", " green-border");
        }
        else {
            mob.className = mob.className.replace(" green-border", " red-border");
        }
    }
    else{
        mob.className = mob.className + " red-border";
    }
}

function passordSjekk() {
    passord = pass.value;
    if (pass.className.includes("border")){
        if (passord.match(passRuleGood)) {
            pass.className = pass.className.replace(" yellow-border", " green-border");
            pass.className = pass.className.replace(" red-border", " green-border");
        }
        else if (passord.match(passRuleMin)) {
            pass.className = pass.className.replace(" red-border", " yellow-border");
            pass.className = pass.className.replace(" green-border", " yellow-border");
        }
        else {
            pass.className = pass.className.replace(" green-border", " red-border");
            pass.className = pass.className.replace(" yellow-border", " red-border");
        }
    }
    else {
        pass.className = pass.className + " red-border";
    }
}

function init() {
    const mob = document.getElementById("mob");

    const pass = document.getElementById("pass");

    mob.addEventListener('input', mobilSjekk);
    pass.addEventListener('input', passordSjekk);
}
document.addEventListener('DOMContentLoaded', init);