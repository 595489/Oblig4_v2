const fornavnRule = new RegExp("^[A-Z][a-z_-]{2,20}$");
const etternavnRule = new RegExp("^[A-Z][a-z_-]{2,20}$");
const phoneRule = new RegExp('^\\d{8}$');

// const passRuleMin = new RegExp('/^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,}$/'); // Fant denne som jeg tror er bra. Hvis denne matcher blir feltet orange
// const passRuleGood = new RegExp('/^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{16,}$/'); // Samme som over, men med 16 tegn. Hvis denne matcher blir feltet grønt
// const passRuleMin = new RegExp('/^(?=.+\\d)(?=.+[a-z])(?=.+[A-Z]).{8,}$/'); // Mulig denne er bedre. Skal tillate tegn og mellomrom, burde teste begge, orange
// const passRuleGood = new RegExp('/^(?=.+\\d)(?=.+[a-z])(?=.+[A-Z]).{16,}$/'); // Mulig denne er bedre. Skal tillate tegn og mellomrom, burde teste begge, grønt
const passRuleMin = new RegExp("^.{4,}$");
const passRuleGood = new RegExp("^.{8,}$");

function fornavnSjekk() {
    let fornavn = fn.value;
    if (fn.className.includes("border")){
        if (fornavn.match(fornavnRule)){
            fn.className = fn.className.replace(" red-border", " green-border");
        }
        else {
            fn.className = fn.className.replace(" green-border", " red-border");
        }
    }
    else {
        fn.className = fn.className + " red-border";
    }

}

function etternavnSjekk() {
    let etternavn = en.value;
    if (en.className.includes("border")){
        if (etternavn.match(fornavnRule)){
            en.className = en.className.replace(" red-border", " green-border");
        }
        else {
            en.className = en.className.replace(" green-border", " red-border");
        }
    }
    else {
        en.className = en.className + " red-border";
    }
}

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

function passordRepSjekk() {
    let passordRep = passRep.value;
    if (passRep.className.includes("border")){
        if (passordRep === pass.value && passordRep !== "") {
            passRep.className = passRep.className.replace(" red-border", " green-border");
        }
        else {
            passRep.className = passRep.className.replace(" green-border", " red-border");
        }
    }
    else {
        passRep.className = passRep.className + " red-border";
    }
}

function init() {
    const fn = document.getElementById("fn");
    const fnRed = fn.className + " red-border";

    const en = document.getElementById("en");
    const enRed = en.className + " red-border";

    const mob = document.getElementById("mob");

    const pass = document.getElementById("pass");

    const passRep = document.getElementById("passRep");

    fn.addEventListener('input', fornavnSjekk);
    en.addEventListener('input', etternavnSjekk);
    mob.addEventListener('input', mobilSjekk);
    pass.addEventListener('input', passordSjekk);
    passRep.addEventListener('input', passordRepSjekk);


    // const input = document.querySelector('input');
    // const log = document.getElementById('values');
    //
    // input.addEventListener('input', updateValue);
}
document.addEventListener('DOMContentLoaded', init);





// function checkField(){
//     var f = document.getElementById('<name of field>').value;
//     if (f === "") {
//         document.getElementById('<name of field>').className = document.getElementById('<name of field>').className + " error";
//         return false;
//     }
// }

// $("input").change(function()
// {
//     var value = $(this).val();
//     if(value=="")
//     {
//         $(this).addClass("red-border");
//         $(this).focus();
//     }else
//     {
//         $(this).removeClass("red-border");
//     }
// });