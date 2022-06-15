package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcgetpacientefamiliarporpaciente extends GXProcedure
{
   public prcgetpacientefamiliarporpaciente( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcgetpacientefamiliarporpaciente.class ), "" );
   }

   public prcgetpacientefamiliarporpaciente( int remoteHandle ,
                                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFamiliar> executeUdp( int aP0 ,
                                                                                              int aP1 )
   {
      prcgetpacientefamiliarporpaciente.this.aP2 = new GXBaseCollection[] {new GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFamiliar>()};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        int aP1 ,
                        GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFamiliar>[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             int aP1 ,
                             GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFamiliar>[] aP2 )
   {
      prcgetpacientefamiliarporpaciente.this.AV8PacienteId = aP0;
      prcgetpacientefamiliarporpaciente.this.AV12PacienteFamiliarId = aP1;
      prcgetpacientefamiliarporpaciente.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P005P2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8PacienteId), Integer.valueOf(AV12PacienteFamiliarId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A20PacienteId = P005P2_A20PacienteId[0] ;
         A105PacienteNombres = P005P2_A105PacienteNombres[0] ;
         A103PacienteApellidoPaterno = P005P2_A103PacienteApellidoPaterno[0] ;
         A104PacienteApellidoMaterno = P005P2_A104PacienteApellidoMaterno[0] ;
         A214PacienteTipoDocumento = P005P2_A214PacienteTipoDocumento[0] ;
         A106PacienteNroDocumento = P005P2_A106PacienteNroDocumento[0] ;
         A213PacienteFechaNacimiento = P005P2_A213PacienteFechaNacimiento[0] ;
         A216PacienteSexo = P005P2_A216PacienteSexo[0] ;
         A220PacienteEstatura = P005P2_A220PacienteEstatura[0] ;
         A221PacientePeso = P005P2_A221PacientePeso[0] ;
         A46SGPacienteHijoPacienteId = P005P2_A46SGPacienteHijoPacienteId[0] ;
         A45PacienteFamiliarId = P005P2_A45PacienteFamiliarId[0] ;
         A105PacienteNombres = P005P2_A105PacienteNombres[0] ;
         A103PacienteApellidoPaterno = P005P2_A103PacienteApellidoPaterno[0] ;
         A104PacienteApellidoMaterno = P005P2_A104PacienteApellidoMaterno[0] ;
         A214PacienteTipoDocumento = P005P2_A214PacienteTipoDocumento[0] ;
         A106PacienteNroDocumento = P005P2_A106PacienteNroDocumento[0] ;
         A213PacienteFechaNacimiento = P005P2_A213PacienteFechaNacimiento[0] ;
         A216PacienteSexo = P005P2_A216PacienteSexo[0] ;
         A220PacienteEstatura = P005P2_A220PacienteEstatura[0] ;
         A221PacientePeso = P005P2_A221PacientePeso[0] ;
         /* Using cursor P005P3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(A20PacienteId), Integer.valueOf(A46SGPacienteHijoPacienteId), Integer.valueOf(AV12PacienteFamiliarId)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            AV10Familiar = (com.projectthani.SdtSDTInformacionDelPacienteFamiliar)new com.projectthani.SdtSDTInformacionDelPacienteFamiliar(remoteHandle, context);
            AV10Familiar.setgxTv_SdtSDTInformacionDelPacienteFamiliar_Nombres( A105PacienteNombres );
            AV10Familiar.setgxTv_SdtSDTInformacionDelPacienteFamiliar_Apellidopaterno( A103PacienteApellidoPaterno );
            AV10Familiar.setgxTv_SdtSDTInformacionDelPacienteFamiliar_Apellidomaterno( A104PacienteApellidoMaterno );
            AV10Familiar.setgxTv_SdtSDTInformacionDelPacienteFamiliar_Tipodocumento( com.projectthani.gxdomaintipodocumento.getDescription(httpContext,(String)A214PacienteTipoDocumento) );
            AV10Familiar.setgxTv_SdtSDTInformacionDelPacienteFamiliar_Nrodocumento( A106PacienteNroDocumento );
            GXt_dtime1 = GXutil.resetTime( A213PacienteFechaNacimiento );
            AV10Familiar.setgxTv_SdtSDTInformacionDelPacienteFamiliar_Fechanacimiento( localUtil.dtoc( A213PacienteFechaNacimiento, 3, "/")+" ("+GXutil.str( GXutil.age( GXt_dtime1, GXutil.now( )), 10, 0)+" años)" );
            AV10Familiar.setgxTv_SdtSDTInformacionDelPacienteFamiliar_Sexo( com.projectthani.gxdomainsexo.getDescription(httpContext,(String)A216PacienteSexo) );
            AV10Familiar.setgxTv_SdtSDTInformacionDelPacienteFamiliar_Estatura( A220PacienteEstatura );
            AV10Familiar.setgxTv_SdtSDTInformacionDelPacienteFamiliar_Peso( A221PacientePeso );
            AV10Familiar.setgxTv_SdtSDTInformacionDelPacienteFamiliar_Motivoconsulta( "" );
            AV11ListadoFamiliar.add(AV10Familiar, 0);
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(1);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = prcgetpacientefamiliarporpaciente.this.AV11ListadoFamiliar;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11ListadoFamiliar = new GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFamiliar>(com.projectthani.SdtSDTInformacionDelPacienteFamiliar.class, "SDTInformacionDelPacienteFamiliar", "ProjectThani", remoteHandle);
      scmdbuf = "" ;
      P005P2_A20PacienteId = new int[1] ;
      P005P2_A105PacienteNombres = new String[] {""} ;
      P005P2_A103PacienteApellidoPaterno = new String[] {""} ;
      P005P2_A104PacienteApellidoMaterno = new String[] {""} ;
      P005P2_A214PacienteTipoDocumento = new String[] {""} ;
      P005P2_A106PacienteNroDocumento = new String[] {""} ;
      P005P2_A213PacienteFechaNacimiento = new java.util.Date[] {GXutil.nullDate()} ;
      P005P2_A216PacienteSexo = new String[] {""} ;
      P005P2_A220PacienteEstatura = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P005P2_A221PacientePeso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P005P2_A46SGPacienteHijoPacienteId = new int[1] ;
      P005P2_A45PacienteFamiliarId = new int[1] ;
      A105PacienteNombres = "" ;
      A103PacienteApellidoPaterno = "" ;
      A104PacienteApellidoMaterno = "" ;
      A214PacienteTipoDocumento = "" ;
      A106PacienteNroDocumento = "" ;
      A213PacienteFechaNacimiento = GXutil.nullDate() ;
      A216PacienteSexo = "" ;
      A220PacienteEstatura = DecimalUtil.ZERO ;
      A221PacientePeso = DecimalUtil.ZERO ;
      P005P3_A20PacienteId = new int[1] ;
      AV10Familiar = new com.projectthani.SdtSDTInformacionDelPacienteFamiliar(remoteHandle, context);
      GXt_dtime1 = GXutil.resetTime( GXutil.nullDate() );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcgetpacientefamiliarporpaciente__default(),
         new Object[] {
             new Object[] {
            P005P2_A20PacienteId, P005P2_A105PacienteNombres, P005P2_A103PacienteApellidoPaterno, P005P2_A104PacienteApellidoMaterno, P005P2_A214PacienteTipoDocumento, P005P2_A106PacienteNroDocumento, P005P2_A213PacienteFechaNacimiento, P005P2_A216PacienteSexo, P005P2_A220PacienteEstatura, P005P2_A221PacientePeso,
            P005P2_A46SGPacienteHijoPacienteId, P005P2_A45PacienteFamiliarId
            }
            , new Object[] {
            P005P3_A20PacienteId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8PacienteId ;
   private int AV12PacienteFamiliarId ;
   private int A20PacienteId ;
   private int A46SGPacienteHijoPacienteId ;
   private int A45PacienteFamiliarId ;
   private java.math.BigDecimal A220PacienteEstatura ;
   private java.math.BigDecimal A221PacientePeso ;
   private String scmdbuf ;
   private String A214PacienteTipoDocumento ;
   private String A216PacienteSexo ;
   private java.util.Date GXt_dtime1 ;
   private java.util.Date A213PacienteFechaNacimiento ;
   private String A105PacienteNombres ;
   private String A103PacienteApellidoPaterno ;
   private String A104PacienteApellidoMaterno ;
   private String A106PacienteNroDocumento ;
   private GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFamiliar>[] aP2 ;
   private IDataStoreProvider pr_default ;
   private int[] P005P2_A20PacienteId ;
   private String[] P005P2_A105PacienteNombres ;
   private String[] P005P2_A103PacienteApellidoPaterno ;
   private String[] P005P2_A104PacienteApellidoMaterno ;
   private String[] P005P2_A214PacienteTipoDocumento ;
   private String[] P005P2_A106PacienteNroDocumento ;
   private java.util.Date[] P005P2_A213PacienteFechaNacimiento ;
   private String[] P005P2_A216PacienteSexo ;
   private java.math.BigDecimal[] P005P2_A220PacienteEstatura ;
   private java.math.BigDecimal[] P005P2_A221PacientePeso ;
   private int[] P005P2_A46SGPacienteHijoPacienteId ;
   private int[] P005P2_A45PacienteFamiliarId ;
   private int[] P005P3_A20PacienteId ;
   private GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFamiliar> AV11ListadoFamiliar ;
   private com.projectthani.SdtSDTInformacionDelPacienteFamiliar AV10Familiar ;
}

final  class prcgetpacientefamiliarporpaciente__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P005P2", "SELECT T1.[PacienteId], T2.[PacienteNombres], T2.[PacienteApellidoPaterno], T2.[PacienteApellidoMaterno], T2.[PacienteTipoDocumento], T2.[PacienteNroDocumento], T2.[PacienteFechaNacimiento], T2.[PacienteSexo], T2.[PacienteEstatura], T2.[PacientePeso], T1.[SGPacienteHijoPacienteId], T1.[PacienteFamiliarId] FROM ([PacienteFamiliar] T1 INNER JOIN [Paciente] T2 ON T2.[PacienteId] = T1.[PacienteId]) WHERE (T1.[PacienteId] = ?) AND (T1.[SGPacienteHijoPacienteId] = ?) ORDER BY T1.[PacienteId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P005P3", "SELECT TOP 1 [PacienteId] FROM [Paciente] WHERE ([PacienteId] = ?) AND (? = ?) ORDER BY [PacienteId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 1);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,2);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,2);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               ((int[]) buf[11])[0] = rslt.getInt(12);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
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
               stmt.setInt(2, ((Number) parms[1]).intValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
   }

}

