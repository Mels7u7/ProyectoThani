package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcautorizacionpagoniubiz extends GXProcedure
{
   public prcautorizacionpagoniubiz( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcautorizacionpagoniubiz.class ), "" );
   }

   public prcautorizacionpagoniubiz( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( String aP0 ,
                            String aP1 ,
                            String aP2 ,
                            String aP3 ,
                            java.math.BigDecimal aP4 ,
                            String aP5 ,
                            String[] aP6 ,
                            com.projectthani.SdtSDTResponseAutorizacionPago200[] aP7 ,
                            com.projectthani.SdtSDTResponseAutorizacionPago400[] aP8 ,
                            com.projectthani.SdtSDTRequestAutorizacionPago[] aP9 )
   {
      prcautorizacionpagoniubiz.this.aP10 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
      return aP10[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String aP3 ,
                        java.math.BigDecimal aP4 ,
                        String aP5 ,
                        String[] aP6 ,
                        com.projectthani.SdtSDTResponseAutorizacionPago200[] aP7 ,
                        com.projectthani.SdtSDTResponseAutorizacionPago400[] aP8 ,
                        com.projectthani.SdtSDTRequestAutorizacionPago[] aP9 ,
                        short[] aP10 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 ,
                             java.math.BigDecimal aP4 ,
                             String aP5 ,
                             String[] aP6 ,
                             com.projectthani.SdtSDTResponseAutorizacionPago200[] aP7 ,
                             com.projectthani.SdtSDTResponseAutorizacionPago400[] aP8 ,
                             com.projectthani.SdtSDTRequestAutorizacionPago[] aP9 ,
                             short[] aP10 )
   {
      prcautorizacionpagoniubiz.this.AV9accessToken = aP0;
      prcautorizacionpagoniubiz.this.AV19merchantId = aP1;
      prcautorizacionpagoniubiz.this.AV10tokenId = aP2;
      prcautorizacionpagoniubiz.this.AV11purchaseNumber = aP3;
      prcautorizacionpagoniubiz.this.AV12amount = aP4;
      prcautorizacionpagoniubiz.this.AV13currency = aP5;
      prcautorizacionpagoniubiz.this.aP6 = aP6;
      prcautorizacionpagoniubiz.this.aP7 = aP7;
      prcautorizacionpagoniubiz.this.aP8 = aP8;
      prcautorizacionpagoniubiz.this.aP9 = aP9;
      prcautorizacionpagoniubiz.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV14HttpClient = (com.genexus.internet.HttpClient)new com.genexus.internet.HttpClient();
      GXt_char1 = "" ;
      GXv_char2[0] = GXt_char1 ;
      new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "hostNiubiz", GXv_char2) ;
      prcautorizacionpagoniubiz.this.GXt_char1 = GXv_char2[0] ;
      AV14HttpClient.setHost( GXt_char1 );
      AV14HttpClient.setPort( 443 );
      AV14HttpClient.setSecure( (byte)(1) );
      GXt_char1 = "" ;
      GXv_char2[0] = GXt_char1 ;
      new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "baseUrlAutorizacionPagoNiubiz", GXv_char2) ;
      prcautorizacionpagoniubiz.this.GXt_char1 = GXv_char2[0] ;
      AV14HttpClient.setBaseURL( GXt_char1 );
      AV8SDTRequesteAutorizacionPago.setgxTv_SdtSDTRequestAutorizacionPago_Capturetype( "manual" );
      AV8SDTRequesteAutorizacionPago.setgxTv_SdtSDTRequestAutorizacionPago_Channel( "web" );
      AV8SDTRequesteAutorizacionPago.getgxTv_SdtSDTRequestAutorizacionPago_Order().setgxTv_SdtSDTRequestOrder_Amount( AV12amount );
      AV8SDTRequesteAutorizacionPago.getgxTv_SdtSDTRequestAutorizacionPago_Order().setgxTv_SdtSDTRequestOrder_Currency( AV13currency );
      AV8SDTRequesteAutorizacionPago.getgxTv_SdtSDTRequestAutorizacionPago_Order().setgxTv_SdtSDTRequestOrder_Purchasenumber( AV11purchaseNumber );
      AV8SDTRequesteAutorizacionPago.getgxTv_SdtSDTRequestAutorizacionPago_Order().setgxTv_SdtSDTRequestOrder_Tokenid( AV10tokenId );
      AV14HttpClient.addHeader("Content-Type", "application/json");
      AV14HttpClient.addHeader("Authorization", AV9accessToken);
      AV14HttpClient.addString(AV8SDTRequesteAutorizacionPago.toJSonString(false, true));
      AV14HttpClient.execute("POST", new com.projectthani.prcgetconfigvalue(remoteHandle, context).executeUdp( "methodAutorizacionPagoNiubiz")+GXutil.trim( AV19merchantId));
      AV15HttpStatus = (short)(GXutil.Int( AV14HttpClient.getStatusCode())) ;
      if ( AV15HttpStatus == 200 )
      {
         AV17SDTResponseAutorizacionPago200.fromJSonString(AV14HttpClient.getString(), null);
      }
      if ( AV15HttpStatus == 400 )
      {
         AV18SDTResponseAutorizacionPago400.fromJSonString(AV14HttpClient.getString(), null);
      }
      if ( ( AV15HttpStatus != 200 ) && ( AV15HttpStatus != 400 ) )
      {
         AV16Errormessage = AV14HttpClient.getString() ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = prcautorizacionpagoniubiz.this.AV16Errormessage;
      this.aP7[0] = prcautorizacionpagoniubiz.this.AV17SDTResponseAutorizacionPago200;
      this.aP8[0] = prcautorizacionpagoniubiz.this.AV18SDTResponseAutorizacionPago400;
      this.aP9[0] = prcautorizacionpagoniubiz.this.AV8SDTRequesteAutorizacionPago;
      this.aP10[0] = prcautorizacionpagoniubiz.this.AV15HttpStatus;
      CloseOpenCursors();
      AV14HttpClient.cleanup();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV16Errormessage = "" ;
      AV17SDTResponseAutorizacionPago200 = new com.projectthani.SdtSDTResponseAutorizacionPago200(remoteHandle, context);
      AV18SDTResponseAutorizacionPago400 = new com.projectthani.SdtSDTResponseAutorizacionPago400(remoteHandle, context);
      AV8SDTRequesteAutorizacionPago = new com.projectthani.SdtSDTRequestAutorizacionPago(remoteHandle, context);
      AV14HttpClient = new com.genexus.internet.HttpClient();
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV15HttpStatus ;
   private short Gx_err ;
   private java.math.BigDecimal AV12amount ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String AV9accessToken ;
   private String AV19merchantId ;
   private String AV10tokenId ;
   private String AV11purchaseNumber ;
   private String AV13currency ;
   private String AV16Errormessage ;
   private short[] aP10 ;
   private String[] aP6 ;
   private com.projectthani.SdtSDTResponseAutorizacionPago200[] aP7 ;
   private com.projectthani.SdtSDTResponseAutorizacionPago400[] aP8 ;
   private com.projectthani.SdtSDTRequestAutorizacionPago[] aP9 ;
   private com.genexus.internet.HttpClient AV14HttpClient ;
   private com.projectthani.SdtSDTRequestAutorizacionPago AV8SDTRequesteAutorizacionPago ;
   private com.projectthani.SdtSDTResponseAutorizacionPago200 AV17SDTResponseAutorizacionPago200 ;
   private com.projectthani.SdtSDTResponseAutorizacionPago400 AV18SDTResponseAutorizacionPago400 ;
}

