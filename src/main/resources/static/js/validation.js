const fornavnRule = new RegExp("^[A-Z][a-z_-]{2,20}$");
const etternavnRule = new RegExp("^[A-Z][a-z_-]{2,20}$");
const phoneRule = new RegExp('^\\d{8}$');

const passRuleMin = new RegExp('/^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,}$/'); // Fant denne som jeg tror er bra. Hvis denne matcher blir feltet orange
const passRuleGood = new RegExp('/^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{16,}$/') // Samme som over, men med 16 tegn. Hvis denne matcher blir feltet grønt
// const passRuleMin = new RegExp('/^(?=.+\\d)(?=.+[a-z])(?=.+[A-Z]).{8,}$/'); // Mulig denne er bedre. Skal tillate tegn og mellomrom, burde teste begge, orange
// const passRuleGood = new RegExp('/^(?=.+\\d)(?=.+[a-z])(?=.+[A-Z]).{16,}$/'); // Mulig denne er bedre. Skal tillate tegn og mellomrom, burde teste begge, grønt




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