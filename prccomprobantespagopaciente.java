package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prccomprobantespagopaciente extends GXProcedure
{
   public prccomprobantespagopaciente( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prccomprobantespagopaciente.class ), "" );
   }

   public prccomprobantespagopaciente( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.projectthani.SdtSDTComprobantesPagoPaciente> executeUdp( int aP0 )
   {
      prccomprobantespagopaciente.this.aP1 = new GXBaseCollection[] {new GXBaseCollection<com.projectthani.SdtSDTComprobantesPagoPaciente>()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        GXBaseCollection<com.projectthani.SdtSDTComprobantesPagoPaciente>[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             GXBaseCollection<com.projectthani.SdtSDTComprobantesPagoPaciente>[] aP1 )
   {
      prccomprobantespagopaciente.this.AV8PacienteId = aP0;
      prccomprobantespagopaciente.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P007S2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8PacienteId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A20PacienteId = P007S2_A20PacienteId[0] ;
         A106PacienteNroDocumento = P007S2_A106PacienteNroDocumento[0] ;
         AV9PacienteNroDocumento = A106PacienteNroDocumento ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      /* Using cursor P007S3 */
      pr_default.execute(1, new Object[] {AV9PacienteNroDocumento});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A248PagoClienteNroDocumento = P007S3_A248PagoClienteNroDocumento[0] ;
         A311PagoStatusCode = P007S3_A311PagoStatusCode[0] ;
         A19CitaId = P007S3_A19CitaId[0] ;
         n19CitaId = P007S3_n19CitaId[0] ;
         A47PagoId = P007S3_A47PagoId[0] ;
         A242PagoMonto = P007S3_A242PagoMonto[0] ;
         A64CitaCode = P007S3_A64CitaCode[0] ;
         A247PagoTipoDocumentoCliente = P007S3_A247PagoTipoDocumentoCliente[0] ;
         A249PagoClienteDenominacion = P007S3_A249PagoClienteDenominacion[0] ;
         A250PagoClienteDireccion = P007S3_A250PagoClienteDireccion[0] ;
         A251PagoClienteEmail = P007S3_A251PagoClienteEmail[0] ;
         A244PagoTipoDocumento = P007S3_A244PagoTipoDocumento[0] ;
         A245PagoNumero = P007S3_A245PagoNumero[0] ;
         A253PagoMoneda = P007S3_A253PagoMoneda[0] ;
         A256PagoNubefactRequest = P007S3_A256PagoNubefactRequest[0] ;
         A257PagoNubefactResponse = P007S3_A257PagoNubefactResponse[0] ;
         A308PagoRequest = P007S3_A308PagoRequest[0] ;
         A309PagoResponse = P007S3_A309PagoResponse[0] ;
         A34DisponibilidadId = P007S3_A34DisponibilidadId[0] ;
         n34DisponibilidadId = P007S3_n34DisponibilidadId[0] ;
         A246PagoEstadoR = P007S3_A246PagoEstadoR[0] ;
         A338PagoEnlacePDF = P007S3_A338PagoEnlacePDF[0] ;
         A339PagoEnlaceXML = P007S3_A339PagoEnlaceXML[0] ;
         A252PagoFechaEmision = P007S3_A252PagoFechaEmision[0] ;
         A64CitaCode = P007S3_A64CitaCode[0] ;
         AV10PagoItem = (com.projectthani.SdtSDTComprobantesPagoPaciente)new com.projectthani.SdtSDTComprobantesPagoPaciente(remoteHandle, context);
         AV10PagoItem.setgxTv_SdtSDTComprobantesPagoPaciente_Pagoid( A47PagoId );
         AV10PagoItem.setgxTv_SdtSDTComprobantesPagoPaciente_Pagomonto( A242PagoMonto );
         AV10PagoItem.setgxTv_SdtSDTComprobantesPagoPaciente_Citaid( A19CitaId );
         AV10PagoItem.setgxTv_SdtSDTComprobantesPagoPaciente_Citacode( A64CitaCode );
         AV10PagoItem.setgxTv_SdtSDTComprobantesPagoPaciente_Pagotipodocumentocliente( A247PagoTipoDocumentoCliente );
         AV10PagoItem.setgxTv_SdtSDTComprobantesPagoPaciente_Pagoclientenrodocumento( A248PagoClienteNroDocumento );
         AV10PagoItem.setgxTv_SdtSDTComprobantesPagoPaciente_Pagoclientedenominacion( A249PagoClienteDenominacion );
         AV10PagoItem.setgxTv_SdtSDTComprobantesPagoPaciente_Pagoclientedireccion( A250PagoClienteDireccion );
         AV10PagoItem.setgxTv_SdtSDTComprobantesPagoPaciente_Pagoclienteemail( A251PagoClienteEmail );
         AV10PagoItem.setgxTv_SdtSDTComprobantesPagoPaciente_Pagotipodocumento( A244PagoTipoDocumento );
         AV10PagoItem.setgxTv_SdtSDTComprobantesPagoPaciente_Pagonumero( A245PagoNumero );
         AV10PagoItem.setgxTv_SdtSDTComprobantesPagoPaciente_Pagofechaemision( A252PagoFechaEmision );
         AV10PagoItem.setgxTv_SdtSDTComprobantesPagoPaciente_Pagomoneda( A253PagoMoneda );
         AV10PagoItem.setgxTv_SdtSDTComprobantesPagoPaciente_Pagonubefactrequest( A256PagoNubefactRequest );
         AV10PagoItem.setgxTv_SdtSDTComprobantesPagoPaciente_Pagonubefactresponse( A257PagoNubefactResponse );
         AV10PagoItem.setgxTv_SdtSDTComprobantesPagoPaciente_Pagorequest( A308PagoRequest );
         AV10PagoItem.setgxTv_SdtSDTComprobantesPagoPaciente_Pagoresponse( A309PagoResponse );
         AV10PagoItem.setgxTv_SdtSDTComprobantesPagoPaciente_Disponibilidadid( A34DisponibilidadId );
         AV10PagoItem.setgxTv_SdtSDTComprobantesPagoPaciente_Pagoestador( A246PagoEstadoR );
         AV10PagoItem.setgxTv_SdtSDTComprobantesPagoPaciente_Pagoenlacepdf( A338PagoEnlacePDF );
         AV10PagoItem.setgxTv_SdtSDTComprobantesPagoPaciente_Pagoenlacexml( A339PagoEnlaceXML );
         AV11PagoList.add(AV10PagoItem, 0);
         pr_default.readNext(1);
      }
      pr_default.close(1);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = prccomprobantespagopaciente.this.AV11PagoList;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11PagoList = new GXBaseCollection<com.projectthani.SdtSDTComprobantesPagoPaciente>(com.projectthani.SdtSDTComprobantesPagoPaciente.class, "SDTComprobantesPagoPaciente", "ProjectThani", remoteHandle);
      scmdbuf = "" ;
      P007S2_A20PacienteId = new int[1] ;
      P007S2_A106PacienteNroDocumento = new String[] {""} ;
      A106PacienteNroDocumento = "" ;
      AV9PacienteNroDocumento = "" ;
      P007S3_A248PagoClienteNroDocumento = new String[] {""} ;
      P007S3_A311PagoStatusCode = new int[1] ;
      P007S3_A19CitaId = new int[1] ;
      P007S3_n19CitaId = new boolean[] {false} ;
      P007S3_A47PagoId = new int[1] ;
      P007S3_A242PagoMonto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P007S3_A64CitaCode = new String[] {""} ;
      P007S3_A247PagoTipoDocumentoCliente = new String[] {""} ;
      P007S3_A249PagoClienteDenominacion = new String[] {""} ;
      P007S3_A250PagoClienteDireccion = new String[] {""} ;
      P007S3_A251PagoClienteEmail = new String[] {""} ;
      P007S3_A244PagoTipoDocumento = new short[1] ;
      P007S3_A245PagoNumero = new int[1] ;
      P007S3_A253PagoMoneda = new short[1] ;
      P007S3_A256PagoNubefactRequest = new String[] {""} ;
      P007S3_A257PagoNubefactResponse = new String[] {""} ;
      P007S3_A308PagoRequest = new String[] {""} ;
      P007S3_A309PagoResponse = new String[] {""} ;
      P007S3_A34DisponibilidadId = new int[1] ;
      P007S3_n34DisponibilidadId = new boolean[] {false} ;
      P007S3_A246PagoEstadoR = new String[] {""} ;
      P007S3_A338PagoEnlacePDF = new String[] {""} ;
      P007S3_A339PagoEnlaceXML = new String[] {""} ;
      P007S3_A252PagoFechaEmision = new java.util.Date[] {GXutil.nullDate()} ;
      A248PagoClienteNroDocumento = "" ;
      A242PagoMonto = DecimalUtil.ZERO ;
      A64CitaCode = "" ;
      A247PagoTipoDocumentoCliente = "" ;
      A249PagoClienteDenominacion = "" ;
      A250PagoClienteDireccion = "" ;
      A251PagoClienteEmail = "" ;
      A256PagoNubefactRequest = "" ;
      A257PagoNubefactResponse = "" ;
      A308PagoRequest = "" ;
      A309PagoResponse = "" ;
      A246PagoEstadoR = "" ;
      A338PagoEnlacePDF = "" ;
      A339PagoEnlaceXML = "" ;
      A252PagoFechaEmision = GXutil.nullDate() ;
      AV10PagoItem = new com.projectthani.SdtSDTComprobantesPagoPaciente(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prccomprobantespagopaciente__default(),
         new Object[] {
             new Object[] {
            P007S2_A20PacienteId, P007S2_A106PacienteNroDocumento
            }
            , new Object[] {
            P007S3_A248PagoClienteNroDocumento, P007S3_A311PagoStatusCode, P007S3_A19CitaId, P007S3_n19CitaId, P007S3_A47PagoId, P007S3_A242PagoMonto, P007S3_A64CitaCode, P007S3_A247PagoTipoDocumentoCliente, P007S3_A249PagoClienteDenominacion, P007S3_A250PagoClienteDireccion,
            P007S3_A251PagoClienteEmail, P007S3_A244PagoTipoDocumento, P007S3_A245PagoNumero, P007S3_A253PagoMoneda, P007S3_A256PagoNubefactRequest, P007S3_A257PagoNubefactResponse, P007S3_A308PagoRequest, P007S3_A309PagoResponse, P007S3_A34DisponibilidadId, P007S3_n34DisponibilidadId,
            P007S3_A246PagoEstadoR, P007S3_A338PagoEnlacePDF, P007S3_A339PagoEnlaceXML, P007S3_A252PagoFechaEmision
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short A244PagoTipoDocumento ;
   private short A253PagoMoneda ;
   private short Gx_err ;
   private int AV8PacienteId ;
   private int A20PacienteId ;
   private int A311PagoStatusCode ;
   private int A19CitaId ;
   private int A47PagoId ;
   private int A245PagoNumero ;
   private int A34DisponibilidadId ;
   private java.math.BigDecimal A242PagoMonto ;
   private String scmdbuf ;
   private String A247PagoTipoDocumentoCliente ;
   private String A246PagoEstadoR ;
   private java.util.Date A252PagoFechaEmision ;
   private boolean n19CitaId ;
   private boolean n34DisponibilidadId ;
   private String A256PagoNubefactRequest ;
   private String A257PagoNubefactResponse ;
   private String A308PagoRequest ;
   private String A309PagoResponse ;
   private String A106PacienteNroDocumento ;
   private String AV9PacienteNroDocumento ;
   private String A248PagoClienteNroDocumento ;
   private String A64CitaCode ;
   private String A249PagoClienteDenominacion ;
   private String A250PagoClienteDireccion ;
   private String A251PagoClienteEmail ;
   private String A338PagoEnlacePDF ;
   private String A339PagoEnlaceXML ;
   private GXBaseCollection<com.projectthani.SdtSDTComprobantesPagoPaciente>[] aP1 ;
   private IDataStoreProvider pr_default ;
   private int[] P007S2_A20PacienteId ;
   private String[] P007S2_A106PacienteNroDocumento ;
   private String[] P007S3_A248PagoClienteNroDocumento ;
   private int[] P007S3_A311PagoStatusCode ;
   private int[] P007S3_A19CitaId ;
   private boolean[] P007S3_n19CitaId ;
   private int[] P007S3_A47PagoId ;
   private java.math.BigDecimal[] P007S3_A242PagoMonto ;
   private String[] P007S3_A64CitaCode ;
   private String[] P007S3_A247PagoTipoDocumentoCliente ;
   private String[] P007S3_A249PagoClienteDenominacion ;
   private String[] P007S3_A250PagoClienteDireccion ;
   private String[] P007S3_A251PagoClienteEmail ;
   private short[] P007S3_A244PagoTipoDocumento ;
   private int[] P007S3_A245PagoNumero ;
   private short[] P007S3_A253PagoMoneda ;
   private String[] P007S3_A256PagoNubefactRequest ;
   private String[] P007S3_A257PagoNubefactResponse ;
   private String[] P007S3_A308PagoRequest ;
   private String[] P007S3_A309PagoResponse ;
   private int[] P007S3_A34DisponibilidadId ;
   private boolean[] P007S3_n34DisponibilidadId ;
   private String[] P007S3_A246PagoEstadoR ;
   private String[] P007S3_A338PagoEnlacePDF ;
   private String[] P007S3_A339PagoEnlaceXML ;
   private java.util.Date[] P007S3_A252PagoFechaEmision ;
   private GXBaseCollection<com.projectthani.SdtSDTComprobantesPagoPaciente> AV11PagoList ;
   private com.projectthani.SdtSDTComprobantesPagoPaciente AV10PagoItem ;
}

final  class prccomprobantespagopaciente__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P007S2", "SELECT TOP 1 [PacienteId], [PacienteNroDocumento] FROM [Paciente] WHERE [PacienteId] = ? ORDER BY [PacienteId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P007S3", "SELECT T1.[PagoClienteNroDocumento], T1.[PagoStatusCode], T1.[CitaId], T1.[PagoId], T1.[PagoMonto], T2.[CitaCode], T1.[PagoTipoDocumentoCliente], T1.[PagoClienteDenominacion], T1.[PagoClienteDireccion], T1.[PagoClienteEmail], T1.[PagoTipoDocumento], T1.[PagoNumero], T1.[PagoMoneda], T1.[PagoNubefactRequest], T1.[PagoNubefactResponse], T1.[PagoRequest], T1.[PagoResponse], T1.[DisponibilidadId], T1.[PagoEstadoR], T1.[PagoEnlacePDF], T1.[PagoEnlaceXML], T1.[PagoFechaEmision] FROM ([Pago] T1 LEFT JOIN [Cita] T2 ON T2.[CitaId] = T1.[CitaId]) WHERE (Not (T1.[CitaId] = convert(int, 0))) AND (T1.[PagoClienteNroDocumento] = ?) AND (T1.[PagoStatusCode] = 200) ORDER BY T1.[PagoFechaEmision] DESC ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(5,2);
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 1);
               ((String[]) buf[8])[0] = rslt.getVarchar(8);
               ((String[]) buf[9])[0] = rslt.getVarchar(9);
               ((String[]) buf[10])[0] = rslt.getVarchar(10);
               ((short[]) buf[11])[0] = rslt.getShort(11);
               ((int[]) buf[12])[0] = rslt.getInt(12);
               ((short[]) buf[13])[0] = rslt.getShort(13);
               ((String[]) buf[14])[0] = rslt.getLongVarchar(14);
               ((String[]) buf[15])[0] = rslt.getLongVarchar(15);
               ((String[]) buf[16])[0] = rslt.getLongVarchar(16);
               ((String[]) buf[17])[0] = rslt.getLongVarchar(17);
               ((int[]) buf[18])[0] = rslt.getInt(18);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getString(19, 1);
               ((String[]) buf[21])[0] = rslt.getVarchar(20);
               ((String[]) buf[22])[0] = rslt.getVarchar(21);
               ((java.util.Date[]) buf[23])[0] = rslt.getGXDate(22);
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
            case 1 :
               stmt.setVarchar(1, (String)parms[0], 15);
               return;
      }
   }

}

