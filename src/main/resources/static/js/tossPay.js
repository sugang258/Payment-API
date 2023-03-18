var clientKey = 'test_ck_4Gv6LjeKD8aYbwLd50x8wYxAdXy1';
var tossPayments = TossPayments(clientKey);
var button = document.getElementById('tossPay');

button.addEventListener('click',function() {
    tossPayments.requestPayment('카드', {
        amount : 100,
        orderId : 'toss-Pay' + new Date().getTime(),
        orderName : 'iphone',
        customerName : 'sugang',
        successUrl : 'http://localhost:8080/success',
        failUrl : 'http://localhost:8080/fail',
    });
})