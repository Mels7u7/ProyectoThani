var JSSinch = function() {
    return {
        joinGroupCall: function (roonName,userId,applicationKey = 'cbabeb14-86d7-4063-8ce6-be59fb6127d1',applicationSecret = 'LiHttzHVgkix1Misaz6F8g==') {
            
          
          let sala = document.getElementById('sala');
            sinchClient = new SinchClient({
              applicationKey: applicationKey,//'cbabeb14-86d7-4063-8ce6-be59fb6127d1',
              applicationSecret: applicationSecret,//'LiHttzHVgkix1Misaz6F8g==', //WARNING: This is insecure, only for demo easy/instant sign-in where we don't care about user identification
              capabilities: {calling: true, video: true, multiCall: true},
              startActiveConnection: true,
              onLogMessage: function(message) {
                console.log(message);
              },
              onLogMxpMessage: function(message) {
                console.log(message);
              },
            });
          
            //Generate & store random username
            var username = userId;//getUuid();
            window.location.hash = window.location.hash || userId;//getUuid(); //random channel name
            channel = roonName;//window.location.hash; //Get channel from the URL hash
            var remoteCalls = []; //Track a number of incoming calls. For more calls - edit the HTML
            console.log('Starting with username: ', username);
            console.log('Will join channel: ', channel);
          
            let myVideo = document.getElementById('me');
            let container = document.getElementById('container');
            //Get callClient, start it and then join the group
            var callClient = sinchClient.getCallClient();
            sinchClient.start({username: username}).then(function() {
            var groupCall = callClient.callGroup(channel);
            
            groupCall.addEventListener({
              
              onGroupRemoteCallAdded: function(call) {
                console.log("Conecte remote");
                console.log(call)
                
                remoteCalls.push(call);
                var callIdx = remoteCalls.indexOf(call);
          
                let nuevoIntegrante = document.createElement('video');
                nuevoIntegrante.id = 'other'+callIdx;
                nuevoIntegrante.autoplay = true;
                nuevoIntegrante.srcObject = call.incomingStream;
                container.appendChild(nuevoIntegrante);
                console.log(nuevoIntegrante);
                //$('video#other'+callIdx).attr('srcObject', call.incomingStream);
              },
              onGroupLocalMediaAdded: function(stream) {
                console.log("Conecte me");
                console.log(stream);
                myVideo.srcObject = stream;
                //$('video#me').attr('srcObject', stream);
                $("video#me").prop("volume", 0);
              },
              onGroupRemoteCallRemoved: function(call) {
                var callIdx = remoteCalls.indexOf(call);
                remoteCalls.splice(callIdx, 1);
                console.log("Group Removed");
                console.log(call);
                $('video[id^=other]').attr('srcObject', function(index) {
                  $('video#other'+index).attr('srcObject', (remoteCalls[index] || {}).incomingStream || '');
                });
              },
            });
          });
        }
    }
}