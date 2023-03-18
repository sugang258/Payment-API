var clientKey = 'test_ck_4Gv6LjeKD8aYbwLd50x8wYxAdXy1';
var tossPayments = TossPayments(clientKey);
var button = document.getElementById('tossPay');

button.addEventListener('click',function() {
    tossPayments.requestPayment('카드', {
        amount : 100,
        orderId : 'toss-Pay' + new Date().getTime(),
        orderName : 'iphone',
        customerName : 'sugang',
        successUrl : 'http://localhost:81/toss/success',
        failUrl : 'http://localhost:81/toss/fail',
    })
    .catch(function(error){
        if(error.code === 'USER_CANCEL') {
            alert("결제 취소");
        }else if(error.code === 'INVALID_CARD_COMPANY') {
            alert('유효하지 않은 카드');
        }
    })
    ;
})