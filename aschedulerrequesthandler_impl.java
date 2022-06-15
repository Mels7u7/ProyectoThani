package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class aschedulerrequesthandler_impl extends GXWebProcedure
{
   public aschedulerrequesthandler_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public void webExecute( )
   {
      if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
      {
         gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
      }
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      entryPointCalled = false ;
      gxfirstwebparm = httpContext.GetNextPar( ) ;
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( toggleJsOutput )
      {
      }
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV21queryString = AV20httpRequest.getQuerystring() ;
      if ( ( GXutil.strSearch( AV21queryString, "&from=", 1) > 0 ) && ( GXutil.strSearch( AV21queryString, "&to=", 1) > 0 ) )
      {
         AV10callbackIndex = (short)(GXutil.strSearch( AV21queryString, "&callback=", 1)) ;
         AV8auxIndex = (short)(GXutil.strSearch( AV21queryString, "&", AV10callbackIndex+10)) ;
         AV9callback = GXutil.substring( AV21queryString, AV10callbackIndex+10, AV8auxIndex-(AV10callbackIndex+10)) ;
         AV12fromIndex = (short)(GXutil.strSearch( AV21queryString, "&from=", 1)) ;
         AV8auxIndex = (short)(GXutil.strSearch( AV21queryString, "&", AV12fromIndex+6)) ;
         AV11from = GXutil.substring( AV21queryString, AV12fromIndex+6, AV8auxIndex-(AV12fromIndex+6)) ;
         AV15toIndex = (short)(GXutil.strSearch( AV21queryString, "&to=", 1)) ;
         AV14to = GXutil.substring( AV21queryString, AV15toIndex+4, GXutil.len( AV21queryString)) ;
         AV19fromCollection = new GXSimpleCollection<String>(String.class, "internal", "", GxRegex.Split(AV11from,"-")) ;
         AV22toCollection = new GXSimpleCollection<String>(String.class, "internal", "", GxRegex.Split(AV14to,"-")) ;
         AV16dateFrom = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( (String)AV19fromCollection.elementAt(-1+1), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( (String)AV19fromCollection.elementAt(-1+2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( (String)AV19fromCollection.elementAt(-1+3), ".")))) ;
         AV17dateTo = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( (String)AV22toCollection.elementAt(-1+1), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( (String)AV22toCollection.elementAt(-1+2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( (String)AV22toCollection.elementAt(-1+3), ".")))) ;
         GXv_date1[0] = AV16dateFrom ;
         GXv_date2[0] = AV17dateTo ;
         GXv_SdtSchedulerEvents3[0] = AV18events;
         callAux3 = new Object[ 3 ];
         callAux3 [ 0 ] = GXv_date1 ;
         callAux3 [ 1 ] = GXv_date2 ;
         callAux3 [ 2 ] = GXv_SdtSchedulerEvents3 ;
         wjAuxLoc = formatLink(AV9callback, new String[] {GXutil.URLEncode(GXutil.formatDateParm(AV16dateFrom)),GXutil.URLEncode(GXutil.formatDateParm(AV17dateTo))}, new String[] {})  ;
         httpContext.wjLoc = DynamicExecute.dynamicWebExecute(context, remoteHandle, getClass(), httpContext.wjLoc, wjAuxLoc,  "com.projectthani." ,  AV9callback ,  callAux3 );
         aschedulerrequesthandler_impl.this.AV16dateFrom = GXv_date1[0] ;
         aschedulerrequesthandler_impl.this.AV17dateTo = GXv_date2[0] ;
         AV18events = GXv_SdtSchedulerEvents3[0] ;
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         AV13httpResponse.addHeader("Content-Type", "text/xml");
      }
      AV13httpResponse.addString(AV18events.toxml(false, true, "data", ""));
      if ( httpContext.willRedirect( ) )
      {
         httpContext.redirect( httpContext.wjLoc );
         httpContext.wjLoc = "" ;
      }
      cleanup();
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      super.cleanup();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXKey = "" ;
      gxfirstwebparm = "" ;
      AV21queryString = "" ;
      AV20httpRequest = httpContext.getHttpRequest();
      AV9callback = "" ;
      AV11from = "" ;
      AV14to = "" ;
      AV19fromCollection = new GXSimpleCollection<String>(String.class, "internal", "");
      AV22toCollection = new GXSimpleCollection<String>(String.class, "internal", "");
      AV16dateFrom = GXutil.nullDate() ;
      AV17dateTo = GXutil.nullDate() ;
      AV18events = new com.projectthani.SdtSchedulerEvents(remoteHandle, context);
      GXv_date1 = new java.util.Date[1] ;
      GXv_date2 = new java.util.Date[1] ;
      GXv_SdtSchedulerEvents3 = new com.projectthani.SdtSchedulerEvents[1] ;
      wjAuxLoc = "" ;
      AV13httpResponse = httpContext.getHttpResponse();
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short gxcookieaux ;
   private short AV10callbackIndex ;
   private short AV8auxIndex ;
   private short AV12fromIndex ;
   private short AV15toIndex ;
   private short Gx_err ;
   private String GXKey ;
   private String gxfirstwebparm ;
   private String AV21queryString ;
   private String AV9callback ;
   private String AV11from ;
   private String AV14to ;
   private String wjAuxLoc ;
   private java.util.Date AV16dateFrom ;
   private java.util.Date AV17dateTo ;
   private java.util.Date GXv_date1[] ;
   private java.util.Date GXv_date2[] ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private com.genexus.internet.HttpRequest AV20httpRequest ;
   private Object[] callAux3 ;
   private com.genexus.internet.HttpResponse AV13httpResponse ;
   private GXSimpleCollection<String> AV19fromCollection ;
   private GXSimpleCollection<String> AV22toCollection ;
   private com.projectthani.SdtSchedulerEvents AV18events ;
   private com.projectthani.SdtSchedulerEvents GXv_SdtSchedulerEvents3[] ;
}

