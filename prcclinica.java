package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcclinica extends GXProcedure
{
   public prcclinica( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcclinica.class ), "" );
   }

   public prcclinica( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.projectthani.SdtSDTClinica> executeUdp( )
   {
      prcclinica.this.aP0 = new GXBaseCollection[] {new GXBaseCollection<com.projectthani.SdtSDTClinica>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBaseCollection<com.projectthani.SdtSDTClinica>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBaseCollection<com.projectthani.SdtSDTClinica>[] aP0 )
   {
      prcclinica.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00802 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         A28ClinicaId = P00802_A28ClinicaId[0] ;
         A40000ClinicaLogo_GXI = P00802_A40000ClinicaLogo_GXI[0] ;
         A40001ClinicaLogoHeader_GXI = P00802_A40001ClinicaLogoHeader_GXI[0] ;
         n40001ClinicaLogoHeader_GXI = P00802_n40001ClinicaLogoHeader_GXI[0] ;
         A40002ClinicaLogoFactura_GXI = P00802_A40002ClinicaLogoFactura_GXI[0] ;
         n40002ClinicaLogoFactura_GXI = P00802_n40002ClinicaLogoFactura_GXI[0] ;
         A40003ClinicaLogoBoleta_GXI = P00802_A40003ClinicaLogoBoleta_GXI[0] ;
         n40003ClinicaLogoBoleta_GXI = P00802_n40003ClinicaLogoBoleta_GXI[0] ;
         A40004ClinicaLogoPago_GXI = P00802_A40004ClinicaLogoPago_GXI[0] ;
         n40004ClinicaLogoPago_GXI = P00802_n40004ClinicaLogoPago_GXI[0] ;
         A118ClinicaRUC = P00802_A118ClinicaRUC[0] ;
         A116ClinicaNombreComercial = P00802_A116ClinicaNombreComercial[0] ;
         A80ClinicaNombreAbreviado = P00802_A80ClinicaNombreAbreviado[0] ;
         A119ClinicaDireccionComercial = P00802_A119ClinicaDireccionComercial[0] ;
         A117ClinicaLogo = P00802_A117ClinicaLogo[0] ;
         A340ClinicaCorreo = P00802_A340ClinicaCorreo[0] ;
         A341ClinicaMoneda = P00802_A341ClinicaMoneda[0] ;
         A342ClinicaLogoHeader = P00802_A342ClinicaLogoHeader[0] ;
         n342ClinicaLogoHeader = P00802_n342ClinicaLogoHeader[0] ;
         A343ClinicaLogoFactura = P00802_A343ClinicaLogoFactura[0] ;
         n343ClinicaLogoFactura = P00802_n343ClinicaLogoFactura[0] ;
         A344ClinicaLogoBoleta = P00802_A344ClinicaLogoBoleta[0] ;
         n344ClinicaLogoBoleta = P00802_n344ClinicaLogoBoleta[0] ;
         A345ClinicaLogoPago = P00802_A345ClinicaLogoPago[0] ;
         n345ClinicaLogoPago = P00802_n345ClinicaLogoPago[0] ;
         A346ClinicaTelefono = P00802_A346ClinicaTelefono[0] ;
         A347ClinicaWhatsApp = P00802_A347ClinicaWhatsApp[0] ;
         A348ClinicaFacebook = P00802_A348ClinicaFacebook[0] ;
         A349ClinicaTwiter = P00802_A349ClinicaTwiter[0] ;
         A350ClinicaInstagram = P00802_A350ClinicaInstagram[0] ;
         A351ClinicaLinkedin = P00802_A351ClinicaLinkedin[0] ;
         A120ClinicaTiempoDeCita = P00802_A120ClinicaTiempoDeCita[0] ;
         A121ClinicaEstado = P00802_A121ClinicaEstado[0] ;
         AV8ClinicaItem = (com.projectthani.SdtSDTClinica)new com.projectthani.SdtSDTClinica(remoteHandle, context);
         AV8ClinicaItem.setgxTv_SdtSDTClinica_Clinicaid( A28ClinicaId );
         AV8ClinicaItem.setgxTv_SdtSDTClinica_Clinicaruc( A118ClinicaRUC );
         AV8ClinicaItem.setgxTv_SdtSDTClinica_Clinicanombrecomercial( A116ClinicaNombreComercial );
         AV8ClinicaItem.setgxTv_SdtSDTClinica_Clinicanombreabreviado( A80ClinicaNombreAbreviado );
         AV8ClinicaItem.setgxTv_SdtSDTClinica_Clinicadireccioncomercial( A119ClinicaDireccionComercial );
         AV8ClinicaItem.setgxTv_SdtSDTClinica_Clinicalogo( A117ClinicaLogo );
         AV8ClinicaItem.setgxTv_SdtSDTClinica_Clinicalogo_gxi( A40000ClinicaLogo_GXI );
         AV8ClinicaItem.setgxTv_SdtSDTClinica_Clinicacorreo( A340ClinicaCorreo );
         AV8ClinicaItem.setgxTv_SdtSDTClinica_Clinicamoneda( A341ClinicaMoneda );
         AV8ClinicaItem.setgxTv_SdtSDTClinica_Clinicalogoheader( A342ClinicaLogoHeader );
         AV8ClinicaItem.setgxTv_SdtSDTClinica_Clinicalogoheader_gxi( A40001ClinicaLogoHeader_GXI );
         AV8ClinicaItem.setgxTv_SdtSDTClinica_Clinicalogofactura( A343ClinicaLogoFactura );
         AV8ClinicaItem.setgxTv_SdtSDTClinica_Clinicalogofactura_gxi( A40002ClinicaLogoFactura_GXI );
         AV8ClinicaItem.setgxTv_SdtSDTClinica_Clinicalogoboleta( A344ClinicaLogoBoleta );
         AV8ClinicaItem.setgxTv_SdtSDTClinica_Clinicalogoboleta_gxi( A40003ClinicaLogoBoleta_GXI );
         AV8ClinicaItem.setgxTv_SdtSDTClinica_Clinicalogopago( A345ClinicaLogoPago );
         AV8ClinicaItem.setgxTv_SdtSDTClinica_Clinicalogopago_gxi( A40004ClinicaLogoPago_GXI );
         AV8ClinicaItem.setgxTv_SdtSDTClinica_Clinicatelefono( A346ClinicaTelefono );
         AV8ClinicaItem.setgxTv_SdtSDTClinica_Clinicawhatsapp( A347ClinicaWhatsApp );
         AV8ClinicaItem.setgxTv_SdtSDTClinica_Clinicafacebook( A348ClinicaFacebook );
         AV8ClinicaItem.setgxTv_SdtSDTClinica_Clinicatwiter( A349ClinicaTwiter );
         AV8ClinicaItem.setgxTv_SdtSDTClinica_Clinicainstagram( A350ClinicaInstagram );
         AV8ClinicaItem.setgxTv_SdtSDTClinica_Clinicalinkedin( A351ClinicaLinkedin );
         AV8ClinicaItem.setgxTv_SdtSDTClinica_Clinicatiempodecita( A120ClinicaTiempoDeCita );
         AV8ClinicaItem.setgxTv_SdtSDTClinica_Clinicaestado( A121ClinicaEstado );
         AV9ClinicaList.add(AV8ClinicaItem, 0);
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = prcclinica.this.AV9ClinicaList;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9ClinicaList = new GXBaseCollection<com.projectthani.SdtSDTClinica>(com.projectthani.SdtSDTClinica.class, "SDTClinica", "ProjectThani", remoteHandle);
      scmdbuf = "" ;
      P00802_A28ClinicaId = new short[1] ;
      P00802_A40000ClinicaLogo_GXI = new String[] {""} ;
      P00802_A40001ClinicaLogoHeader_GXI = new String[] {""} ;
      P00802_n40001ClinicaLogoHeader_GXI = new boolean[] {false} ;
      P00802_A40002ClinicaLogoFactura_GXI = new String[] {""} ;
      P00802_n40002ClinicaLogoFactura_GXI = new boolean[] {false} ;
      P00802_A40003ClinicaLogoBoleta_GXI = new String[] {""} ;
      P00802_n40003ClinicaLogoBoleta_GXI = new boolean[] {false} ;
      P00802_A40004ClinicaLogoPago_GXI = new String[] {""} ;
      P00802_n40004ClinicaLogoPago_GXI = new boolean[] {false} ;
      P00802_A118ClinicaRUC = new long[1] ;
      P00802_A116ClinicaNombreComercial = new String[] {""} ;
      P00802_A80ClinicaNombreAbreviado = new String[] {""} ;
      P00802_A119ClinicaDireccionComercial = new String[] {""} ;
      P00802_A117ClinicaLogo = new String[] {""} ;
      P00802_A340ClinicaCorreo = new String[] {""} ;
      P00802_A341ClinicaMoneda = new short[1] ;
      P00802_A342ClinicaLogoHeader = new String[] {""} ;
      P00802_n342ClinicaLogoHeader = new boolean[] {false} ;
      P00802_A343ClinicaLogoFactura = new String[] {""} ;
      P00802_n343ClinicaLogoFactura = new boolean[] {false} ;
      P00802_A344ClinicaLogoBoleta = new String[] {""} ;
      P00802_n344ClinicaLogoBoleta = new boolean[] {false} ;
      P00802_A345ClinicaLogoPago = new String[] {""} ;
      P00802_n345ClinicaLogoPago = new boolean[] {false} ;
      P00802_A346ClinicaTelefono = new String[] {""} ;
      P00802_A347ClinicaWhatsApp = new String[] {""} ;
      P00802_A348ClinicaFacebook = new String[] {""} ;
      P00802_A349ClinicaTwiter = new String[] {""} ;
      P00802_A350ClinicaInstagram = new String[] {""} ;
      P00802_A351ClinicaLinkedin = new String[] {""} ;
      P00802_A120ClinicaTiempoDeCita = new byte[1] ;
      P00802_A121ClinicaEstado = new String[] {""} ;
      A40000ClinicaLogo_GXI = "" ;
      A40001ClinicaLogoHeader_GXI = "" ;
      A40002ClinicaLogoFactura_GXI = "" ;
      A40003ClinicaLogoBoleta_GXI = "" ;
      A40004ClinicaLogoPago_GXI = "" ;
      A116ClinicaNombreComercial = "" ;
      A80ClinicaNombreAbreviado = "" ;
      A119ClinicaDireccionComercial = "" ;
      A117ClinicaLogo = "" ;
      A340ClinicaCorreo = "" ;
      A342ClinicaLogoHeader = "" ;
      A343ClinicaLogoFactura = "" ;
      A344ClinicaLogoBoleta = "" ;
      A345ClinicaLogoPago = "" ;
      A346ClinicaTelefono = "" ;
      A347ClinicaWhatsApp = "" ;
      A348ClinicaFacebook = "" ;
      A349ClinicaTwiter = "" ;
      A350ClinicaInstagram = "" ;
      A351ClinicaLinkedin = "" ;
      A121ClinicaEstado = "" ;
      AV8ClinicaItem = new com.projectthani.SdtSDTClinica(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcclinica__default(),
         new Object[] {
             new Object[] {
            P00802_A28ClinicaId, P00802_A40000ClinicaLogo_GXI, P00802_A40001ClinicaLogoHeader_GXI, P00802_n40001ClinicaLogoHeader_GXI, P00802_A40002ClinicaLogoFactura_GXI, P00802_n40002ClinicaLogoFactura_GXI, P00802_A40003ClinicaLogoBoleta_GXI, P00802_n40003ClinicaLogoBoleta_GXI, P00802_A40004ClinicaLogoPago_GXI, P00802_n40004ClinicaLogoPago_GXI,
            P00802_A118ClinicaRUC, P00802_A116ClinicaNombreComercial, P00802_A80ClinicaNombreAbreviado, P00802_A119ClinicaDireccionComercial, P00802_A117ClinicaLogo, P00802_A340ClinicaCorreo, P00802_A341ClinicaMoneda, P00802_A342ClinicaLogoHeader, P00802_n342ClinicaLogoHeader, P00802_A343ClinicaLogoFactura,
            P00802_n343ClinicaLogoFactura, P00802_A344ClinicaLogoBoleta, P00802_n344ClinicaLogoBoleta, P00802_A345ClinicaLogoPago, P00802_n345ClinicaLogoPago, P00802_A346ClinicaTelefono, P00802_A347ClinicaWhatsApp, P00802_A348ClinicaFacebook, P00802_A349ClinicaTwiter, P00802_A350ClinicaInstagram,
            P00802_A351ClinicaLinkedin, P00802_A120ClinicaTiempoDeCita, P00802_A121ClinicaEstado
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A120ClinicaTiempoDeCita ;
   private short A28ClinicaId ;
   private short A341ClinicaMoneda ;
   private short Gx_err ;
   private long A118ClinicaRUC ;
   private String scmdbuf ;
   private String A346ClinicaTelefono ;
   private String A347ClinicaWhatsApp ;
   private String A121ClinicaEstado ;
   private boolean n40001ClinicaLogoHeader_GXI ;
   private boolean n40002ClinicaLogoFactura_GXI ;
   private boolean n40003ClinicaLogoBoleta_GXI ;
   private boolean n40004ClinicaLogoPago_GXI ;
   private boolean n342ClinicaLogoHeader ;
   private boolean n343ClinicaLogoFactura ;
   private boolean n344ClinicaLogoBoleta ;
   private boolean n345ClinicaLogoPago ;
   private String A40000ClinicaLogo_GXI ;
   private String A40001ClinicaLogoHeader_GXI ;
   private String A40002ClinicaLogoFactura_GXI ;
   private String A40003ClinicaLogoBoleta_GXI ;
   private String A40004ClinicaLogoPago_GXI ;
   private String A116ClinicaNombreComercial ;
   private String A80ClinicaNombreAbreviado ;
   private String A119ClinicaDireccionComercial ;
   private String A340ClinicaCorreo ;
   private String A348ClinicaFacebook ;
   private String A349ClinicaTwiter ;
   private String A350ClinicaInstagram ;
   private String A351ClinicaLinkedin ;
   private String A117ClinicaLogo ;
   private String A342ClinicaLogoHeader ;
   private String A343ClinicaLogoFactura ;
   private String A344ClinicaLogoBoleta ;
   private String A345ClinicaLogoPago ;
   private GXBaseCollection<com.projectthani.SdtSDTClinica>[] aP0 ;
   private IDataStoreProvider pr_default ;
   private short[] P00802_A28ClinicaId ;
   private String[] P00802_A40000ClinicaLogo_GXI ;
   private String[] P00802_A40001ClinicaLogoHeader_GXI ;
   private boolean[] P00802_n40001ClinicaLogoHeader_GXI ;
   private String[] P00802_A40002ClinicaLogoFactura_GXI ;
   private boolean[] P00802_n40002ClinicaLogoFactura_GXI ;
   private String[] P00802_A40003ClinicaLogoBoleta_GXI ;
   private boolean[] P00802_n40003ClinicaLogoBoleta_GXI ;
   private String[] P00802_A40004ClinicaLogoPago_GXI ;
   private boolean[] P00802_n40004ClinicaLogoPago_GXI ;
   private long[] P00802_A118ClinicaRUC ;
   private String[] P00802_A116ClinicaNombreComercial ;
   private String[] P00802_A80ClinicaNombreAbreviado ;
   private String[] P00802_A119ClinicaDireccionComercial ;
   private String[] P00802_A117ClinicaLogo ;
   private String[] P00802_A340ClinicaCorreo ;
   private short[] P00802_A341ClinicaMoneda ;
   private String[] P00802_A342ClinicaLogoHeader ;
   private boolean[] P00802_n342ClinicaLogoHeader ;
   private String[] P00802_A343ClinicaLogoFactura ;
   private boolean[] P00802_n343ClinicaLogoFactura ;
   private String[] P00802_A344ClinicaLogoBoleta ;
   private boolean[] P00802_n344ClinicaLogoBoleta ;
   private String[] P00802_A345ClinicaLogoPago ;
   private boolean[] P00802_n345ClinicaLogoPago ;
   private String[] P00802_A346ClinicaTelefono ;
   private String[] P00802_A347ClinicaWhatsApp ;
   private String[] P00802_A348ClinicaFacebook ;
   private String[] P00802_A349ClinicaTwiter ;
   private String[] P00802_A350ClinicaInstagram ;
   private String[] P00802_A351ClinicaLinkedin ;
   private byte[] P00802_A120ClinicaTiempoDeCita ;
   private String[] P00802_A121ClinicaEstado ;
   private GXBaseCollection<com.projectthani.SdtSDTClinica> AV9ClinicaList ;
   private com.projectthani.SdtSDTClinica AV8ClinicaItem ;
}

final  class prcclinica__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00802", "SELECT TOP 1 [ClinicaId], [ClinicaLogo_GXI], [ClinicaLogoHeader_GXI], [ClinicaLogoFactura_GXI], [ClinicaLogoBoleta_GXI], [ClinicaLogoPago_GXI], [ClinicaRUC], [ClinicaNombreComercial], [ClinicaNombreAbreviado], [ClinicaDireccionComercial], [ClinicaLogo], [ClinicaCorreo], [ClinicaMoneda], [ClinicaLogoHeader], [ClinicaLogoFactura], [ClinicaLogoBoleta], [ClinicaLogoPago], [ClinicaTelefono], [ClinicaWhatsApp], [ClinicaFacebook], [ClinicaTwiter], [ClinicaInstagram], [ClinicaLinkedin], [ClinicaTiempoDeCita], [ClinicaEstado] FROM [Clinica] WHERE [ClinicaId] = 1 ORDER BY [ClinicaId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getMultimediaUri(2);
               ((String[]) buf[2])[0] = rslt.getMultimediaUri(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getMultimediaUri(4);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getMultimediaUri(5);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getMultimediaUri(6);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((long[]) buf[10])[0] = rslt.getLong(7);
               ((String[]) buf[11])[0] = rslt.getVarchar(8);
               ((String[]) buf[12])[0] = rslt.getVarchar(9);
               ((String[]) buf[13])[0] = rslt.getVarchar(10);
               ((String[]) buf[14])[0] = rslt.getMultimediaFile(11, rslt.getVarchar(2));
               ((String[]) buf[15])[0] = rslt.getVarchar(12);
               ((short[]) buf[16])[0] = rslt.getShort(13);
               ((String[]) buf[17])[0] = rslt.getMultimediaFile(14, rslt.getVarchar(3));
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((String[]) buf[19])[0] = rslt.getMultimediaFile(15, rslt.getVarchar(4));
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((String[]) buf[21])[0] = rslt.getMultimediaFile(16, rslt.getVarchar(5));
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((String[]) buf[23])[0] = rslt.getMultimediaFile(17, rslt.getVarchar(6));
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((String[]) buf[25])[0] = rslt.getString(18, 12);
               ((String[]) buf[26])[0] = rslt.getString(19, 15);
               ((String[]) buf[27])[0] = rslt.getVarchar(20);
               ((String[]) buf[28])[0] = rslt.getVarchar(21);
               ((String[]) buf[29])[0] = rslt.getVarchar(22);
               ((String[]) buf[30])[0] = rslt.getVarchar(23);
               ((byte[]) buf[31])[0] = rslt.getByte(24);
               ((String[]) buf[32])[0] = rslt.getString(25, 1);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
      }
   }

}

