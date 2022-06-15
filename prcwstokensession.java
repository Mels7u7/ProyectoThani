package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcwstokensession extends GXProcedure
{
   public prcwstokensession( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcwstokensession.class ), "" );
   }

   public prcwstokensession( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             java.math.BigDecimal aP1 ,
                             String aP2 ,
                             int aP3 ,
                             String aP4 ,
                             String[] aP5 ,
                             String[] aP6 ,
                             short[] aP7 ,
                             com.projectthani.SdtSDTResponseTokenSession200[] aP8 ,
                             com.projectthani.SdtSDTResponseTokenSession400[] aP9 )
   {
      prcwstokensession.this.aP10 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
      return aP10[0];
   }

   public void execute( String aP0 ,
                        java.math.BigDecimal aP1 ,
                        String aP2 ,
                        int aP3 ,
                        String aP4 ,
                        String[] aP5 ,
                        String[] aP6 ,
                        short[] aP7 ,
                        com.projectthani.SdtSDTResponseTokenSession200[] aP8 ,
                        com.projectthani.SdtSDTResponseTokenSession400[] aP9 ,
                        String[] aP10 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
   }

   private void execute_int( String aP0 ,
                             java.math.BigDecimal aP1 ,
                             String aP2 ,
                             int aP3 ,
                             String aP4 ,
                             String[] aP5 ,
                             String[] aP6 ,
                             short[] aP7 ,
                             com.projectthani.SdtSDTResponseTokenSession200[] aP8 ,
                             com.projectthani.SdtSDTResponseTokenSession400[] aP9 ,
                             String[] aP10 )
   {
      prcwstokensession.this.AV16merchantId = aP0;
      prcwstokensession.this.AV10amount = aP1;
      prcwstokensession.this.AV9accessToken = aP2;
      prcwstokensession.this.AV17PacienteId = aP3;
      prcwstokensession.this.AV23clientIp = aP4;
      prcwstokensession.this.aP5 = aP5;
      prcwstokensession.this.aP6 = aP6;
      prcwstokensession.this.aP7 = aP7;
      prcwstokensession.this.aP8 = aP8;
      prcwstokensession.this.aP9 = aP9;
      prcwstokensession.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P006P3 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV17PacienteId)});
      if ( (pr_default.getStatus(0) != 101) )
      {
         A40000PacienteCorreo = P006P3_A40000PacienteCorreo[0] ;
         n40000PacienteCorreo = P006P3_n40000PacienteCorreo[0] ;
         A40001PacienteNroDocumento = P006P3_A40001PacienteNroDocumento[0] ;
         n40001PacienteNroDocumento = P006P3_n40001PacienteNroDocumento[0] ;
         A40002PacienteFechaRegistro = P006P3_A40002PacienteFechaRegistro[0] ;
         n40002PacienteFechaRegistro = P006P3_n40002PacienteFechaRegistro[0] ;
      }
      else
      {
         A40000PacienteCorreo = "" ;
         n40000PacienteCorreo = false ;
         A40001PacienteNroDocumento = "" ;
         n40001PacienteNroDocumento = false ;
         A40002PacienteFechaRegistro = GXutil.resetTime( GXutil.nullDate() );
         n40002PacienteFechaRegistro = false ;
      }
      pr_default.close(0);
      AV8HttpClient = (com.genexus.internet.HttpClient)new com.genexus.internet.HttpClient();
      GXt_char1 = "" ;
      GXv_char2[0] = GXt_char1 ;
      new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "hostNiubiz", GXv_char2) ;
      prcwstokensession.this.GXt_char1 = GXv_char2[0] ;
      AV8HttpClient.setHost( GXt_char1 );
      AV8HttpClient.setPort( 443 );
      AV8HttpClient.setSecure( (byte)(1) );
      GXt_char1 = "" ;
      GXv_char2[0] = GXt_char1 ;
      new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "baseUrlTokenSessionNiubiz", GXv_char2) ;
      prcwstokensession.this.GXt_char1 = GXv_char2[0] ;
      AV8HttpClient.setBaseURL( GXt_char1 );
      AV8HttpClient.addHeader("Content-Type", "application/json");
      AV8HttpClient.addHeader("Authorization", AV9accessToken);
      AV18SDTRequestTokenSession = (com.projectthani.SdtSDTRequestTokenSession)new com.projectthani.SdtSDTRequestTokenSession(remoteHandle, context);
      AV18SDTRequestTokenSession.setgxTv_SdtSDTRequestTokenSession_Amount( AV10amount );
      AV18SDTRequestTokenSession.setgxTv_SdtSDTRequestTokenSession_Channel( "web" );
      AV18SDTRequestTokenSession.getgxTv_SdtSDTRequestTokenSession_Antifraud().setgxTv_SdtSDTRequestAutorizacionPagoAntifraud_Clientip( AV23clientIp );
      AV18SDTRequestTokenSession.getgxTv_SdtSDTRequestTokenSession_Antifraud().getgxTv_SdtSDTRequestAutorizacionPagoAntifraud_Merchantdefinedata().setgxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd4( A40000PacienteCorreo );
      GXt_char1 = "" ;
      GXv_char2[0] = GXt_char1 ;
      new com.projectthani.prcpacientefrecuente(remoteHandle, context).execute( AV17PacienteId, GXv_char2) ;
      prcwstokensession.this.GXt_char1 = GXv_char2[0] ;
      AV18SDTRequestTokenSession.getgxTv_SdtSDTRequestTokenSession_Antifraud().getgxTv_SdtSDTRequestAutorizacionPagoAntifraud_Merchantdefinedata().setgxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd21( GXt_char1 );
      AV18SDTRequestTokenSession.getgxTv_SdtSDTRequestTokenSession_Antifraud().getgxTv_SdtSDTRequestAutorizacionPagoAntifraud_Merchantdefinedata().setgxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd32( A40001PacienteNroDocumento );
      AV18SDTRequestTokenSession.getgxTv_SdtSDTRequestTokenSession_Antifraud().getgxTv_SdtSDTRequestAutorizacionPagoAntifraud_Merchantdefinedata().setgxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd75( "Registrado" );
      AV13fechaRegistroPaciente = A40002PacienteFechaRegistro ;
      AV11cantidadDias = (int)(GXutil.ddiff(Gx_date,GXutil.resetTime( AV13fechaRegistroPaciente))) ;
      AV18SDTRequestTokenSession.getgxTv_SdtSDTRequestTokenSession_Antifraud().getgxTv_SdtSDTRequestAutorizacionPagoAntifraud_Merchantdefinedata().setgxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd77( GXutil.trim( GXutil.str( AV11cantidadDias, 7, 0)) );
      AV21temp = AV18SDTRequestTokenSession.toJSonString(false, true) ;
      AV8HttpClient.addString(AV18SDTRequestTokenSession.toJSonString(false, true));
      AV8HttpClient.execute("POST", new com.projectthani.prcgetconfigvalue(remoteHandle, context).executeUdp( "methodTokenSessionNiubiz")+GXutil.trim( AV16merchantId));
      AV15HttpStatus = (short)(GXutil.Int( AV8HttpClient.getStatusCode())) ;
      if ( AV15HttpStatus == 200 )
      {
         AV19SDTResponseTokenSession200.fromJSonString(AV8HttpClient.getString(), null);
         AV22tokenSession = AV19SDTResponseTokenSession200.getgxTv_SdtSDTResponseTokenSession200_Sessionkey() ;
      }
      if ( AV15HttpStatus == 400 )
      {
         AV20SDTResponseTokenSession400.fromJSonString(AV8HttpClient.getString(), null);
      }
      if ( ( AV15HttpStatus != 400 ) && ( AV15HttpStatus != 200 ) )
      {
         AV12ErrorMessage = "Ocurrio un error. Contacte con un administrador." ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = prcwstokensession.this.AV22tokenSession;
      this.aP6[0] = prcwstokensession.this.AV12ErrorMessage;
      this.aP7[0] = prcwstokensession.this.AV15HttpStatus;
      this.aP8[0] = prcwstokensession.this.AV19SDTResponseTokenSession200;
      this.aP9[0] = prcwstokensession.this.AV20SDTResponseTokenSession400;
      this.aP10[0] = prcwstokensession.this.AV21temp;
      CloseOpenCursors();
      AV8HttpClient.cleanup();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV22tokenSession = "" ;
      AV12ErrorMessage = "" ;
      AV19SDTResponseTokenSession200 = new com.projectthani.SdtSDTResponseTokenSession200(remoteHandle, context);
      AV20SDTResponseTokenSession400 = new com.projectthani.SdtSDTResponseTokenSession400(remoteHandle, context);
      AV21temp = "" ;
      scmdbuf = "" ;
      P006P3_A40000PacienteCorreo = new String[] {""} ;
      P006P3_n40000PacienteCorreo = new boolean[] {false} ;
      P006P3_A40001PacienteNroDocumento = new String[] {""} ;
      P006P3_n40001PacienteNroDocumento = new boolean[] {false} ;
      P006P3_A40002PacienteFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      P006P3_n40002PacienteFechaRegistro = new boolean[] {false} ;
      A40000PacienteCorreo = "" ;
      A40001PacienteNroDocumento = "" ;
      A40002PacienteFechaRegistro = GXutil.resetTime( GXutil.nullDate() );
      AV8HttpClient = new com.genexus.internet.HttpClient();
      AV18SDTRequestTokenSession = new com.projectthani.SdtSDTRequestTokenSession(remoteHandle, context);
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      AV13fechaRegistroPaciente = GXutil.now( ) ;
      Gx_date = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcwstokensession__default(),
         new Object[] {
             new Object[] {
            P006P3_A40000PacienteCorreo, P006P3_n40000PacienteCorreo, P006P3_A40001PacienteNroDocumento, P006P3_n40001PacienteNroDocumento, P006P3_A40002PacienteFechaRegistro, P006P3_n40002PacienteFechaRegistro
            }
         }
      );
      Gx_date = GXutil.today( ) ;
      /* GeneXus formulas. */
      Gx_date = GXutil.today( ) ;
      Gx_err = (short)(0) ;
   }

   private short AV15HttpStatus ;
   private short Gx_err ;
   private int AV17PacienteId ;
   private int AV11cantidadDias ;
   private java.math.BigDecimal AV10amount ;
   private String AV16merchantId ;
   private String AV22tokenSession ;
   private String scmdbuf ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private java.util.Date A40002PacienteFechaRegistro ;
   private java.util.Date AV13fechaRegistroPaciente ;
   private java.util.Date Gx_date ;
   private boolean n40000PacienteCorreo ;
   private boolean n40001PacienteNroDocumento ;
   private boolean n40002PacienteFechaRegistro ;
   private String AV21temp ;
   private String AV9accessToken ;
   private String AV23clientIp ;
   private String AV12ErrorMessage ;
   private String A40000PacienteCorreo ;
   private String A40001PacienteNroDocumento ;
   private String[] aP10 ;
   private String[] aP5 ;
   private String[] aP6 ;
   private short[] aP7 ;
   private com.projectthani.SdtSDTResponseTokenSession200[] aP8 ;
   private com.projectthani.SdtSDTResponseTokenSession400[] aP9 ;
   private IDataStoreProvider pr_default ;
   private String[] P006P3_A40000PacienteCorreo ;
   private boolean[] P006P3_n40000PacienteCorreo ;
   private String[] P006P3_A40001PacienteNroDocumento ;
   private boolean[] P006P3_n40001PacienteNroDocumento ;
   private java.util.Date[] P006P3_A40002PacienteFechaRegistro ;
   private boolean[] P006P3_n40002PacienteFechaRegistro ;
   private com.genexus.internet.HttpClient AV8HttpClient ;
   private com.projectthani.SdtSDTRequestTokenSession AV18SDTRequestTokenSession ;
   private com.projectthani.SdtSDTResponseTokenSession200 AV19SDTResponseTokenSession200 ;
   private com.projectthani.SdtSDTResponseTokenSession400 AV20SDTResponseTokenSession400 ;
}

final  class prcwstokensession__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P006P3", "SELECT COALESCE( T1.[PacienteCorreo], '') AS PacienteCorreo, COALESCE( T1.[PacienteNroDocumento], '') AS PacienteNroDocumento, COALESCE( T1.[PacienteFechaRegistro], convert( DATETIME, '17530101', 112 )) AS PacienteFechaRegistro FROM (SELECT [PacienteCorreo] AS PacienteCorreo, [PacienteId], [PacienteNroDocumento] AS PacienteNroDocumento, [PacienteFechaRegistro] AS PacienteFechaRegistro FROM [Paciente] WHERE [PacienteId] = ? ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDateTime(3);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

