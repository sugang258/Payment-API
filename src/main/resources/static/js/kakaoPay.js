var pay = document.getElementById("card_pay");
var IMP = window.IMP; 
IMP.init("imp11225448"); 

pay.addEventListener("click",function() {

    IMP.request_pay({
        pg : 'kakaopay',
        pay_method : 'card',
        merchant_uid: 'Danal_'+new Date().getTime(), 
        name : '당근 10kg',
        amount : 100,
        buyer_email : 'Iamport@chai.finance',
        buyer_name : 'sugang',
        buyer_tel : '010-1234-5678',
        buyer_addr : '경기도 수원시',
        buyer_postcode : '123-456'
    }, function (rsp) { // callback
        if (rsp.success) {
            console.log(rsp);
        } else {
            console.log(rsp);
        }
    });
});

$("#kakaoPay").click(function(){
    IMP.request_pay({
        pg : 'kakaopay',
        pay_method : 'card',
        merchant_uid: 'Danal_'+new Date().getTime(), 
        name : '당근 10kg',
        amount : 100,
        buyer_email : 'Iamport@chai.finance',
        buyer_name : 'sugang',
        buyer_tel : '010-1234-5678',
        buyer_addr : '경기도 수원시',
        buyer_postcode : '123-456'
    }, function (rsp) { // callback
        if (rsp.success) {
            console.log(rsp);
        } else {
            console.log(rsp);
        }
    });
})