var JSNiubiz = function() {
    return {
        openForm: function (cardHolderName,cardHolderLastName,cardHolderEmail,sessionToken, channel, merchantId, purchaseNumber, amount, expirationMinutes, timeouturl, merchantLogo, formButtonColor, action) {
            console.log(cardHolderName,cardHolderLastName,cardHolderEmail,cardHolderEmail,sessionToken,channel,merchantId, purchaseNumber, amount, expirationMinutes, timeouturl, merchantLogo, formButtonColor, action);
            VisanetCheckout.configure({
              cardholdername: cardHolderName,
              cardholderlastname: cardHolderLastName,
              cardholderemail: cardHolderEmail,
              sessiontoken: sessionToken,
              channel: channel,
              merchantid: merchantId,
              purchasenumber: purchaseNumber,
              amount: amount,
              expirationminutes: expirationMinutes,
              timeouturl: timeouturl,
              merchantlogo: merchantLogo,
              formbuttoncolor:formButtonColor,
              action: action,
              complete: function(params) {
                alert(JSON.stringify(params));
              }
            });

            VisanetCheckout.open();
        }
    }
}