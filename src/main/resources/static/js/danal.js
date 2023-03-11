var card_pay = document.getElementById("card_pay");
var phone_pay = document.getElementById("phone_pay");

var method;

var IMP = window.IMP; 
IMP.init("imp11225448"); 

card_pay.addEventListener("click", function() {
    IMP.request_pay({
        pg : 'danal_tpay',
        pay_method : 'card',
        merchant_uid: 'Danal_'+new Date().getTime(), 
        name : '다날 휴대폰 결제',
        amount : 100,
        buyer_email : 'Iamport@chai.finance',
        buyer_name : 'sugang',
        buyer_tel : '010-1234-5678',
        buyer_addr : '경기도 수원시',
    }, function (rsp) { // callback
        if (rsp.success) {
            console.log(rsp);
        } else {
            console.log(rsp);
        }
    });
});

phone_pay.addEventListener("click",function(){
    IMP.request_pay({
        pg : 'danal',
        pay_method : 'phone',
        merchant_uid: 'Danal_'+new Date().getTime(), 
        name : '다날 휴대폰 결제',
        amount : 100,
        buyer_email : 'Iamport@chai.finance',
        buyer_name : 'sugang',
        buyer_tel : '010-1234-5678',
        buyer_addr : '경기도 수원시',
        buyer_postcode : '123-456',
        biz_num : '1234567890' //휴대폰 결제 시, 필수 입력
    }, function (rsp) { // callback
        if (rsp.success) {
            console.log(rsp);
        } else {
            console.log(rsp);
        }
    });
});



