gx.hugao={},gx.hugao.jitsiclient=(gx.$,{_JITSI_MEET_API:null,_JITSI_MEET_CONTAINER:"",IsMeetOnFullWindow:!1,UseAllWindowForMeet:!1,TotalParticipantsInMeeting:0,DisposeOnUnload:!1,StartWithPipMode:!1,PipWidth:"300px",PipHeight:"200px",PipLocation:"br",initialize:function(){this.gxevents.attach_gxapp()},gxevents:{attach_gxapp:function(){gx.fx.obs.addObserver("gx.onready",this,gx.hugao.jitsiclient.web.events.onReady),gx.fx.obs.addObserver("gx.onunload",this,gx.hugao.jitsiclient.web.events.onUnload)}},web:{http:{loadScript:function(t,e,i){let n,o=gx.dom.byTag("head")[0],a=document.querySelectorAll('[src="'+t+'"]'),s=document.querySelectorAll('[data-hugao-external-role="hugaojitsi-extapi"]');i&&s.length>0&&e?s[0].src=t:0===a.length?(n=document.createElement("script"),i&&n.setAttribute("data-hugao-external-role","hugaojitsi-extapi"),n.type="text/javascript",n.src=t,o.appendChild(n)):e&&(a[0].src=t)}},events:{onReady:function(){gx.hugao.jitsiclient.web.http.loadScript("https://meet.jit.si/external_api.js",!1,!0)},onUnload:function(){null!==gx.hugao.jitsiclient._JITSI_MEET_API&&gx.hugao.jitsiclient._JITSI_MEET_API instanceof JitsiMeetExternalAPI&&gx.hugao.jitsiclient.DisposeOnUnload&&(gx.hugao.jitsiclient._JITSI_MEET_API.dispose(),gx.hugao.jitsiclient.UseAllWindowForMeet?(gx.hugao.jitsiclient._JITSI_MEET_API.dispose(),document.body.removeChild(gx.dom.byId(gx.hugao.jitsiclient._JITSI_MEET_CONTAINER))):gx.dom.byId(gx.hugao.jitsiclient._JITSI_MEET_CONTAINER).removeChild(gx.hugao.jitsiclient._JITSI_MEET_API.getIFrame()),gx.hugao.jitsiclient.TotalParticipantsInMeeting=gx.hugao.jitsiclient._JITSI_MEET_API.getNumberOfParticipants())}}},meet:{_MEET_OPTIONS:{},_JITSI_MEET_DOMAIN:"",_LocalAvatarUrl:"",prepare:function(t,e){let i="https://".concat(t.Domain).concat("/external_api.js");if(gx.hugao.jitsiclient.web.http.loadScript(i,!0,!0),gx.hugao.jitsiclient.UseAllWindowForMeet){gx.hugao.jitsiclient._JITSI_MEET_CONTAINER="hugao-jitsi-meet-conference";let t=document.createElement("div");t.id=gx.hugao.jitsiclient._JITSI_MEET_CONTAINER,t.style="visible:none;position:absolute;height:100%;width:100%;top:0;z-index:999;";let e=document.createElement("div");if(e.id="hugao-jitsi-meet-arrow",e.style="position:absolute;height:10px;width:10px;top:15px;left:10px;font-size:30px;color:#FFF;transform:rotate(-90deg);cursor:pointer;",e.innerHTML="&lsaquo;",e.addEventListener("click",gx.hugao.jitsiclient.meet.click_events.arrow),t.appendChild(e),document.body.appendChild(t),gx.hugao.jitsiclient.StartWithPipMode){switch(gx.hugao.jitsiclient.PipLocation){case"br":t.style.bottom="15px",t.style.right="15px",t.style.left="",t.style.top="";break;case"bl":t.style.bottom="15px",t.style.right="",t.style.left="15px",t.style.top="";break;case"tr":t.style.top="15px",t.style.bottom="",t.style.right="15px",t.style.left="";break;case"tl":t.style.bottom="",t.style.right="",t.style.left="15px",t.style.top="15px";break;default:t.style.bottom="15px",t.style.right="15px",t.style.left="",t.style.top=""}t.style.width=gx.hugao.jitsiclient.PipWidth,t.style.height=gx.hugao.jitsiclient.PipHeight,t.style.boxShadow="5px 5px 5px 3px #CCCCCC",e.style.transform="rotate(90deg)",e.style.left="35px",gx.hugao.jitsiclient.IsMeetOnFullWindow=!1}else gx.hugao.jitsiclient.IsMeetOnFullWindow=!0}if(null!==t)try{const i=t.Options,n=i.Config,o=n.UI,a=n.Media,s=n.Recording,l=i.UserInfo,g=i.InterfaceConfig;this._LocalAvatarUrl=l.AvatarImage,this._JITSI_MEET_DOMAIN=t.Domain,this._MEET_OPTIONS={roomName:i.RoomName,parentNode:gx.dom.byId(gx.hugao.jitsiclient._JITSI_MEET_CONTAINER),jwt:i.UserJwt,userInfo:{displayName:l.DisplayName,email:l.Email},configOverwrite:{disableDeepLinking:n.DeepLinking,desktopSharingChromeDisabled:!n.SharingChrome,desktopSharingFirefoxDisabled:!n.SharingFirefox,doNotStoreRoom:n.NotStoreRoom,enableWelcomePage:o.WelcomePage,enableClosePage:o.ClosePage,defaultLanguage:""!==o.DefaultLanguage?o.DefaultLanguage:"en",startAudioOnly:a.StartAudioOnly,startWithAudioMuted:a.StartWithAudioMuted,startWithVideoMuted:a.StartWithVideoMuted,resolution:a.Resolution,fileRecordingsServiceSharingEnabled:s.RecordingService,liveStreamingEnabled:s.LiveStreamingEnabled},interfaceConfigOverwrite:{filmStripOnly:g.FilmStripOnly,SHOW_JITSI_WATERMARK:g.JitsiWatermark,SHOW_WATERMARK_FOR_GUESTS:g.WatermarkForGuests,SHOW_BRAND_WATERMARK:g.BrandWatermark,SHOW_POWERED_BY:g.PoweredBy,VERTICAL_FILMSTRIP:g.VerticalFilmstrip,DISABLE_RINGING:g.DisableRinging,MOBILE_APP_PROMO:g.MobileAppPromo,CONNECTION_INDICATOR_DISABLED:g.ConnectionIndicatorDisabled,VIDEO_QUALITY_LABEL_DISABLED:g.VideoQualityLabelDisabled,RECENT_LIST_ENABLED:!1,DEFAULT_LOCAL_DISPLAY_NAME:"Me",DEFAULT_REMOTE_DISPLAY_NAME:"Guest",SETTINGS_SECTIONS:g.SettingsSections,TILE_VIEW_MAX_COLUMNS:1,VIDEO_LAYOUT_FIT:g.VideoLayoutFit,DISABLE_TRANSCRIPTION_SUBTITLES:!0,OPEN_IN_MOBILE_BROWSER:g.OpenInMobileBrowser}},e&&this.launch()}catch(t){console.error("An error ocurred while calling prepare function, error in config"),console.error(t)}else console.error("An error ocurred while calling prepare function, no config recived")},launch:function(){gx.hugao.jitsiclient._JITSI_MEET_API=new JitsiMeetExternalAPI(this._JITSI_MEET_DOMAIN,this._MEET_OPTIONS),null!==gx.hugao.jitsiclient._JITSI_MEET_API&&gx.hugao.jitsiclient._JITSI_MEET_API instanceof JitsiMeetExternalAPI&&(gx.dom.byId(gx.hugao.jitsiclient._JITSI_MEET_CONTAINER).style.display="block",gx.hugao.jitsiclient._JITSI_MEET_API.addEventListeners({incomingMessage:gx.hugao.jitsiclient.handlers.messages.incomingMessageListener,outgoingMessage:gx.hugao.jitsiclient.handlers.messages.outgoingMessageListener,participantJoined:gx.hugao.jitsiclient.handlers.participants.participantJoinedListener,participantLeft:gx.hugao.jitsiclient.handlers.participants.participantLeftListener,videoConferenceJoined:gx.hugao.jitsiclient.handlers.conference.videoConferenceJoinedListener,videoConferenceLeft:gx.hugao.jitsiclient.handlers.conference.videoConferenceLeftListener}))},click_events:{arrow:function(t){if(gx.hugao.jitsiclient.UseAllWindowForMeet){let e=t.srcElement,i=gx.dom.byId(gx.hugao.jitsiclient._JITSI_MEET_CONTAINER);if(gx.hugao.jitsiclient.IsMeetOnFullWindow){switch(gx.hugao.jitsiclient.PipLocation){case"br":i.style.bottom="15px",i.style.right="15px",i.style.left="",i.style.top="";break;case"bl":i.style.bottom="15px",i.style.right="",i.style.left="15px",i.style.top="";break;case"tr":i.style.bottom="",i.style.right="15px",i.style.left="",i.style.top="15px";break;case"tl":i.style.bottom="",i.style.right="",i.style.left="15px",i.style.top="15px";break;default:i.style.bottom="15px",i.style.right="15px",i.style.left="",i.style.top=""}i.style.width=gx.hugao.jitsiclient.PipWidth,i.style.height=gx.hugao.jitsiclient.PipHeight,i.style.boxShadow="5px 5px 5px 3px #CCCCCC",e.style.transform="rotate(90deg)",e.style.left="35px",gx.hugao.jitsiclient.IsMeetOnFullWindow=!1}else i.style.top="0",i.style.width="100%",i.style.height="100%",i.style.right="",i.style.bottom="",i.style.left="",i.style.boxShadow="",e.style.transform="rotate(-90deg)",e.style.left="10px",gx.hugao.jitsiclient.IsMeetOnFullWindow=!0}}},participantsInConference:function(){let t=[];for(let e in gx.hugao.jitsiclient._JITSI_MEET_API._participants){let i=gx.hugao.jitsiclient._JITSI_MEET_API._participants[e];null!==i&&t.push({id:e,displayName:i.displayName,avatarURL:i.avatarURL,formattedDisplayName:i.formattedDisplayName})}return t}},handlers:{messages:{incomingMessageListener:function(t){gx.fx.obs.notify("hugaojitsiclient.web.messages.incoming",[arguments[0]])},outgoingMessageListener:function(t){gx.fx.obs.notify("hugaojitsiclient.web.messages.outgoing",[arguments[0]])}},participants:{participantJoinedListener:function(t){gx.hugao.jitsiclient.TotalParticipantsInMeeting=gx.hugao.jitsiclient._JITSI_MEET_API.getNumberOfParticipants(),gx.hugao.jitsiclient.meet.Participants=gx.hugao.jitsiclient._JITSI_MEET_API._participants,gx.fx.obs.notify("hugaojitsiclient.web.participants.joined",[arguments[0]])},participantLeftListener:function(t){gx.hugao.jitsiclient.TotalParticipantsInMeeting=gx.hugao.jitsiclient._JITSI_MEET_API.getNumberOfParticipants(),gx.hugao.jitsiclient.meet.Participants=gx.hugao.jitsiclient._JITSI_MEET_API._participants,gx.fx.obs.notify("hugaojitsiclient.web.participants.left",[arguments[0]])}},conference:{videoConferenceJoinedListener:function(t){gx.hugao.jitsiclient.TotalParticipantsInMeeting=gx.hugao.jitsiclient._JITSI_MEET_API.getNumberOfParticipants(),gx.hugao.jitsiclient.meet.Participants=gx.hugao.jitsiclient._JITSI_MEET_API._participants,""!==gx.hugao.jitsiclient._LocalAvatarUrl&&gx.hugao.jitsiclient._JITSI_MEET_API.executeCommand("avatarUrl",gx.hugao.jitsiclient.meet._LocalAvatarUrl),gx.fx.obs.notify("hugaojitsiclient.web.conference.joined",[arguments[0]])},videoConferenceLeftListener:function(t){gx.hugao.jitsiclient.UseAllWindowForMeet?(gx.hugao.jitsiclient._JITSI_MEET_API.dispose(),document.body.removeChild(gx.dom.byId(gx.hugao.jitsiclient._JITSI_MEET_CONTAINER))):gx.dom.byId(gx.hugao.jitsiclient._JITSI_MEET_CONTAINER).removeChild(gx.hugao.jitsiclient._JITSI_MEET_API.getIFrame()),gx.hugao.jitsiclient.TotalParticipantsInMeeting=gx.hugao.jitsiclient._JITSI_MEET_API.getNumberOfParticipants(),gx.hugao.jitsiclient.meet.Participants=gx.hugao.jitsiclient._JITSI_MEET_API._participants,gx.fx.obs.notify("hugaojitsiclient.web.conference.left",[arguments[0]])}}}}),gx.hugao.jitsiclient.initialize();