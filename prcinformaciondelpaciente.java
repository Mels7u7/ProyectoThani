package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcinformaciondelpaciente extends GXProcedure
{
   public prcinformaciondelpaciente( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcinformaciondelpaciente.class ), "" );
   }

   public prcinformaciondelpaciente( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.projectthani.SdtSDTInformacionDelPaciente> executeUdp( int aP0 )
   {
      prcinformaciondelpaciente.this.aP1 = new GXBaseCollection[] {new GXBaseCollection<com.projectthani.SdtSDTInformacionDelPaciente>()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        GXBaseCollection<com.projectthani.SdtSDTInformacionDelPaciente>[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             GXBaseCollection<com.projectthani.SdtSDTInformacionDelPaciente>[] aP1 )
   {
      prcinformaciondelpaciente.this.AV11PacienteId = aP0;
      prcinformaciondelpaciente.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P006H2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11PacienteId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A20PacienteId = P006H2_A20PacienteId[0] ;
         A105PacienteNombres = P006H2_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P006H2_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P006H2_A103PacienteApellidoPaterno[0] ;
         A214PacienteTipoDocumento = P006H2_A214PacienteTipoDocumento[0] ;
         A106PacienteNroDocumento = P006H2_A106PacienteNroDocumento[0] ;
         A216PacienteSexo = P006H2_A216PacienteSexo[0] ;
         A217PacienteCorreo = P006H2_A217PacienteCorreo[0] ;
         A213PacienteFechaNacimiento = P006H2_A213PacienteFechaNacimiento[0] ;
         A221PacientePeso = P006H2_A221PacientePeso[0] ;
         A220PacienteEstatura = P006H2_A220PacienteEstatura[0] ;
         AV9PacienteA = (com.projectthani.SdtSDTInformacionDelPaciente)new com.projectthani.SdtSDTInformacionDelPaciente(remoteHandle, context);
         AV9PacienteA.setgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteid( A20PacienteId );
         AV9PacienteA.setgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientenombres( A105PacienteNombres );
         AV9PacienteA.setgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteapellidos( A103PacienteApellidoPaterno+" "+A104PacienteApellidoMaterno );
         AV9PacienteA.setgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientetipodocumento( com.projectthani.gxdomaintipodocumento.getDescription(httpContext,(String)A214PacienteTipoDocumento) );
         AV9PacienteA.setgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientenrodocumento( A106PacienteNroDocumento );
         AV9PacienteA.setgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientesexo( com.projectthani.gxdomainsexo.getDescription(httpContext,(String)A216PacienteSexo) );
         AV9PacienteA.setgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteemail( A217PacienteCorreo );
         GXt_dtime1 = GXutil.resetTime( A213PacienteFechaNacimiento );
         AV9PacienteA.setgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientefechanacimiento( localUtil.dtoc( A213PacienteFechaNacimiento, 3, "/")+" ("+GXutil.str( GXutil.age( GXt_dtime1, GXutil.now( )), 10, 0)+" años )" );
         if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, A221PacientePeso)==0) )
         {
            AV9PacienteA.setgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientepeso( A221PacientePeso );
         }
         else
         {
            AV9PacienteA.setgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientepeso( AV12Peso );
         }
         if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, A220PacienteEstatura)==0) )
         {
            AV9PacienteA.setgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteestatura( A220PacienteEstatura );
         }
         else
         {
            AV9PacienteA.setgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteestatura( AV13Talla );
         }
         AV9PacienteA.setgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientemotivoconsulta( "" );
         AV10PacienteB.add(AV9PacienteA, 0);
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = prcinformaciondelpaciente.this.AV10PacienteB;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10PacienteB = new GXBaseCollection<com.projectthani.SdtSDTInformacionDelPaciente>(com.projectthani.SdtSDTInformacionDelPaciente.class, "SDTInformacionDelPaciente", "ProjectThani", remoteHandle);
      scmdbuf = "" ;
      P006H2_A20PacienteId = new int[1] ;
      P006H2_A105PacienteNombres = new String[] {""} ;
      P006H2_A104PacienteApellidoMaterno = new String[] {""} ;
      P006H2_A103PacienteApellidoPaterno = new String[] {""} ;
      P006H2_A214PacienteTipoDocumento = new String[] {""} ;
      P006H2_A106PacienteNroDocumento = new String[] {""} ;
      P006H2_A216PacienteSexo = new String[] {""} ;
      P006H2_A217PacienteCorreo = new String[] {""} ;
      P006H2_A213PacienteFechaNacimiento = new java.util.Date[] {GXutil.nullDate()} ;
      P006H2_A221PacientePeso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P006H2_A220PacienteEstatura = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A105PacienteNombres = "" ;
      A104PacienteApellidoMaterno = "" ;
      A103PacienteApellidoPaterno = "" ;
      A214PacienteTipoDocumento = "" ;
      A106PacienteNroDocumento = "" ;
      A216PacienteSexo = "" ;
      A217PacienteCorreo = "" ;
      A213PacienteFechaNacimiento = GXutil.nullDate() ;
      A221PacientePeso = DecimalUtil.ZERO ;
      A220PacienteEstatura = DecimalUtil.ZERO ;
      AV9PacienteA = new com.projectthani.SdtSDTInformacionDelPaciente(remoteHandle, context);
      GXt_dtime1 = GXutil.resetTime( GXutil.nullDate() );
      AV12Peso = DecimalUtil.stringToDec("0.00") ;
      AV13Talla = DecimalUtil.stringToDec("0.00") ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcinformaciondelpaciente__default(),
         new Object[] {
             new Object[] {
            P006H2_A20PacienteId, P006H2_A105PacienteNombres, P006H2_A104PacienteApellidoMaterno, P006H2_A103PacienteApellidoPaterno, P006H2_A214PacienteTipoDocumento, P006H2_A106PacienteNroDocumento, P006H2_A216PacienteSexo, P006H2_A217PacienteCorreo, P006H2_A213PacienteFechaNacimiento, P006H2_A221PacientePeso,
            P006H2_A220PacienteEstatura
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV11PacienteId ;
   private int A20PacienteId ;
   private java.math.BigDecimal A221PacientePeso ;
   private java.math.BigDecimal A220PacienteEstatura ;
   private java.math.BigDecimal AV12Peso ;
   private java.math.BigDecimal AV13Talla ;
   private String scmdbuf ;
   private String A214PacienteTipoDocumento ;
   private String A216PacienteSexo ;
   private java.util.Date GXt_dtime1 ;
   private java.util.Date A213PacienteFechaNacimiento ;
   private String A105PacienteNombres ;
   private String A104PacienteApellidoMaterno ;
   private String A103PacienteApellidoPaterno ;
   private String A106PacienteNroDocumento ;
   private String A217PacienteCorreo ;
   private GXBaseCollection<com.projectthani.SdtSDTInformacionDelPaciente>[] aP1 ;
   private IDataStoreProvider pr_default ;
   private int[] P006H2_A20PacienteId ;
   private String[] P006H2_A105PacienteNombres ;
   private String[] P006H2_A104PacienteApellidoMaterno ;
   private String[] P006H2_A103PacienteApellidoPaterno ;
   private String[] P006H2_A214PacienteTipoDocumento ;
   private String[] P006H2_A106PacienteNroDocumento ;
   private String[] P006H2_A216PacienteSexo ;
   private String[] P006H2_A217PacienteCorreo ;
   private java.util.Date[] P006H2_A213PacienteFechaNacimiento ;
   private java.math.BigDecimal[] P006H2_A221PacientePeso ;
   private java.math.BigDecimal[] P006H2_A220PacienteEstatura ;
   private GXBaseCollection<com.projectthani.SdtSDTInformacionDelPaciente> AV10PacienteB ;
   private com.projectthani.SdtSDTInformacionDelPaciente AV9PacienteA ;
}

final  class prcinformaciondelpaciente__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P006H2", "SELECT [PacienteId], [PacienteNombres], [PacienteApellidoMaterno], [PacienteApellidoPaterno], [PacienteTipoDocumento], [PacienteNroDocumento], [PacienteSexo], [PacienteCorreo], [PacienteFechaNacimiento], [PacientePeso], [PacienteEstatura] FROM [Paciente] WHERE [PacienteId] = ? ORDER BY [PacienteId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 1);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(9);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,2);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(11,2);
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

