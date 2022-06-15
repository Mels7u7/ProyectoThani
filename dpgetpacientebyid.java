package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class dpgetpacientebyid extends GXProcedure
{
   public dpgetpacientebyid( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( dpgetpacientebyid.class ), "" );
   }

   public dpgetpacientebyid( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.SdtSDTPacienteData executeUdp( int aP0 )
   {
      dpgetpacientebyid.this.aP1 = new com.projectthani.SdtSDTPacienteData[] {new com.projectthani.SdtSDTPacienteData()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        com.projectthani.SdtSDTPacienteData[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             com.projectthani.SdtSDTPacienteData[] aP1 )
   {
      dpgetpacientebyid.this.AV5PacienteId = aP0;
      dpgetpacientebyid.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P000L2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV5PacienteId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A20PacienteId = P000L2_A20PacienteId[0] ;
         A103PacienteApellidoPaterno = P000L2_A103PacienteApellidoPaterno[0] ;
         A104PacienteApellidoMaterno = P000L2_A104PacienteApellidoMaterno[0] ;
         A105PacienteNombres = P000L2_A105PacienteNombres[0] ;
         A217PacienteCorreo = P000L2_A217PacienteCorreo[0] ;
         A218PacienteTelefono = P000L2_A218PacienteTelefono[0] ;
         A213PacienteFechaNacimiento = P000L2_A213PacienteFechaNacimiento[0] ;
         A106PacienteNroDocumento = P000L2_A106PacienteNroDocumento[0] ;
         A214PacienteTipoDocumento = P000L2_A214PacienteTipoDocumento[0] ;
         A216PacienteSexo = P000L2_A216PacienteSexo[0] ;
         A215PacienteDireccion = P000L2_A215PacienteDireccion[0] ;
         Gxm1sdtpacientedata.setgxTv_SdtSDTPacienteData_Pacienteapellidopaterno( A103PacienteApellidoPaterno );
         Gxm1sdtpacientedata.setgxTv_SdtSDTPacienteData_Pacienteapellidomaterno( A104PacienteApellidoMaterno );
         Gxm1sdtpacientedata.setgxTv_SdtSDTPacienteData_Pacientenombres( A105PacienteNombres );
         Gxm1sdtpacientedata.setgxTv_SdtSDTPacienteData_Pacientecorreo( A217PacienteCorreo );
         Gxm1sdtpacientedata.setgxTv_SdtSDTPacienteData_Pacientetelefono( A218PacienteTelefono );
         Gxm1sdtpacientedata.setgxTv_SdtSDTPacienteData_Pacientefechanacimiento( A213PacienteFechaNacimiento );
         GXt_dtime1 = GXutil.resetTime( A213PacienteFechaNacimiento );
         GXt_dtime2 = GXutil.resetTime( Gx_date );
         Gxm1sdtpacientedata.setgxTv_SdtSDTPacienteData_Pacientefechanacimientodescripcion( localUtil.dtoc( A213PacienteFechaNacimiento, 3, "/")+" ("+GXutil.str( GXutil.age( GXt_dtime1, GXt_dtime2), 10, 0)+" años )" );
         Gxm1sdtpacientedata.setgxTv_SdtSDTPacienteData_Pacientenrodocumento( A106PacienteNroDocumento );
         Gxm1sdtpacientedata.setgxTv_SdtSDTPacienteData_Pacientetipodocumento( A214PacienteTipoDocumento );
         Gxm1sdtpacientedata.setgxTv_SdtSDTPacienteData_Pacientesexo( A216PacienteSexo );
         Gxm1sdtpacientedata.setgxTv_SdtSDTPacienteData_Pacientedireccion( A215PacienteDireccion );
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = dpgetpacientebyid.this.Gxm1sdtpacientedata;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      Gxm1sdtpacientedata = new com.projectthani.SdtSDTPacienteData(remoteHandle, context);
      scmdbuf = "" ;
      P000L2_A20PacienteId = new int[1] ;
      P000L2_A103PacienteApellidoPaterno = new String[] {""} ;
      P000L2_A104PacienteApellidoMaterno = new String[] {""} ;
      P000L2_A105PacienteNombres = new String[] {""} ;
      P000L2_A217PacienteCorreo = new String[] {""} ;
      P000L2_A218PacienteTelefono = new String[] {""} ;
      P000L2_A213PacienteFechaNacimiento = new java.util.Date[] {GXutil.nullDate()} ;
      P000L2_A106PacienteNroDocumento = new String[] {""} ;
      P000L2_A214PacienteTipoDocumento = new String[] {""} ;
      P000L2_A216PacienteSexo = new String[] {""} ;
      P000L2_A215PacienteDireccion = new String[] {""} ;
      A103PacienteApellidoPaterno = "" ;
      A104PacienteApellidoMaterno = "" ;
      A105PacienteNombres = "" ;
      A217PacienteCorreo = "" ;
      A218PacienteTelefono = "" ;
      A213PacienteFechaNacimiento = GXutil.nullDate() ;
      A106PacienteNroDocumento = "" ;
      A214PacienteTipoDocumento = "" ;
      A216PacienteSexo = "" ;
      A215PacienteDireccion = "" ;
      GXt_dtime1 = GXutil.resetTime( GXutil.nullDate() );
      Gx_date = GXutil.nullDate() ;
      GXt_dtime2 = GXutil.resetTime( GXutil.nullDate() );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.dpgetpacientebyid__default(),
         new Object[] {
             new Object[] {
            P000L2_A20PacienteId, P000L2_A103PacienteApellidoPaterno, P000L2_A104PacienteApellidoMaterno, P000L2_A105PacienteNombres, P000L2_A217PacienteCorreo, P000L2_A218PacienteTelefono, P000L2_A213PacienteFechaNacimiento, P000L2_A106PacienteNroDocumento, P000L2_A214PacienteTipoDocumento, P000L2_A216PacienteSexo,
            P000L2_A215PacienteDireccion
            }
         }
      );
      Gx_date = GXutil.today( ) ;
      /* GeneXus formulas. */
      Gx_date = GXutil.today( ) ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV5PacienteId ;
   private int A20PacienteId ;
   private String scmdbuf ;
   private String A218PacienteTelefono ;
   private String A214PacienteTipoDocumento ;
   private String A216PacienteSexo ;
   private java.util.Date GXt_dtime1 ;
   private java.util.Date GXt_dtime2 ;
   private java.util.Date A213PacienteFechaNacimiento ;
   private java.util.Date Gx_date ;
   private String A103PacienteApellidoPaterno ;
   private String A104PacienteApellidoMaterno ;
   private String A105PacienteNombres ;
   private String A217PacienteCorreo ;
   private String A106PacienteNroDocumento ;
   private String A215PacienteDireccion ;
   private com.projectthani.SdtSDTPacienteData[] aP1 ;
   private IDataStoreProvider pr_default ;
   private int[] P000L2_A20PacienteId ;
   private String[] P000L2_A103PacienteApellidoPaterno ;
   private String[] P000L2_A104PacienteApellidoMaterno ;
   private String[] P000L2_A105PacienteNombres ;
   private String[] P000L2_A217PacienteCorreo ;
   private String[] P000L2_A218PacienteTelefono ;
   private java.util.Date[] P000L2_A213PacienteFechaNacimiento ;
   private String[] P000L2_A106PacienteNroDocumento ;
   private String[] P000L2_A214PacienteTipoDocumento ;
   private String[] P000L2_A216PacienteSexo ;
   private String[] P000L2_A215PacienteDireccion ;
   private com.projectthani.SdtSDTPacienteData Gxm1sdtpacientedata ;
}

final  class dpgetpacientebyid__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P000L2", "SELECT [PacienteId], [PacienteApellidoPaterno], [PacienteApellidoMaterno], [PacienteNombres], [PacienteCorreo], [PacienteTelefono], [PacienteFechaNacimiento], [PacienteNroDocumento], [PacienteTipoDocumento], [PacienteSexo], [PacienteDireccion] FROM [Paciente] WHERE [PacienteId] = ? ORDER BY [PacienteId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 1);
               ((String[]) buf[9])[0] = rslt.getString(10, 1);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
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

