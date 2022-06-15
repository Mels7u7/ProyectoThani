package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcgetlistadofamiliarporpaciente extends GXProcedure
{
   public prcgetlistadofamiliarporpaciente( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcgetlistadofamiliarporpaciente.class ), "" );
   }

   public prcgetlistadofamiliarporpaciente( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.projectthani.SdtSDTListadoFamiliarPorPaciente> executeUdp( int aP0 )
   {
      prcgetlistadofamiliarporpaciente.this.aP1 = new GXBaseCollection[] {new GXBaseCollection<com.projectthani.SdtSDTListadoFamiliarPorPaciente>()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        GXBaseCollection<com.projectthani.SdtSDTListadoFamiliarPorPaciente>[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             GXBaseCollection<com.projectthani.SdtSDTListadoFamiliarPorPaciente>[] aP1 )
   {
      prcgetlistadofamiliarporpaciente.this.AV8PacienteId = aP0;
      prcgetlistadofamiliarporpaciente.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P006Z2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8PacienteId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A20PacienteId = P006Z2_A20PacienteId[0] ;
         A46SGPacienteHijoPacienteId = P006Z2_A46SGPacienteHijoPacienteId[0] ;
         A235PacienteFamiliarParentesco = P006Z2_A235PacienteFamiliarParentesco[0] ;
         A45PacienteFamiliarId = P006Z2_A45PacienteFamiliarId[0] ;
         AV10Familiar = (com.projectthani.SdtSDTListadoFamiliarPorPaciente)new com.projectthani.SdtSDTListadoFamiliarPorPaciente(remoteHandle, context);
         AV15Paciente.Load(A46SGPacienteHijoPacienteId);
         AV10Familiar.setgxTv_SdtSDTListadoFamiliarPorPaciente_Pacientefamiliarid( AV15Paciente.getgxTv_SdtPaciente_Pacienteid() );
         AV10Familiar.setgxTv_SdtSDTListadoFamiliarPorPaciente_Sgpacientehijopacienteid( A46SGPacienteHijoPacienteId );
         AV10Familiar.setgxTv_SdtSDTListadoFamiliarPorPaciente_Nombres( AV15Paciente.getgxTv_SdtPaciente_Pacientenombres() );
         AV10Familiar.setgxTv_SdtSDTListadoFamiliarPorPaciente_Apellidos( AV15Paciente.getgxTv_SdtPaciente_Pacienteapellidopaterno()+" "+AV15Paciente.getgxTv_SdtPaciente_Pacienteapellidomaterno() );
         AV10Familiar.setgxTv_SdtSDTListadoFamiliarPorPaciente_Nrodocumento( AV15Paciente.getgxTv_SdtPaciente_Pacientenrodocumento() );
         AV10Familiar.setgxTv_SdtSDTListadoFamiliarPorPaciente_Fechanacimento( AV15Paciente.getgxTv_SdtPaciente_Pacientefechanacimiento() );
         AV10Familiar.setgxTv_SdtSDTListadoFamiliarPorPaciente_Parentesco( com.projectthani.gxdomainparentescofamiliar.getDescription(httpContext,(String)A235PacienteFamiliarParentesco) );
         AV10Familiar.setgxTv_SdtSDTListadoFamiliarPorPaciente_Sexo( AV15Paciente.getgxTv_SdtPaciente_Pacientesexo() );
         AV10Familiar.setgxTv_SdtSDTListadoFamiliarPorPaciente_Estatura( AV15Paciente.getgxTv_SdtPaciente_Pacienteestatura() );
         AV10Familiar.setgxTv_SdtSDTListadoFamiliarPorPaciente_Peso( AV15Paciente.getgxTv_SdtPaciente_Pacientepeso() );
         AV10Familiar.setgxTv_SdtSDTListadoFamiliarPorPaciente_Nacionalidad( AV15Paciente.getgxTv_SdtPaciente_Paisdescripcion() );
         AV11ListadoFamiliar.add(AV10Familiar, 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = prcgetlistadofamiliarporpaciente.this.AV11ListadoFamiliar;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11ListadoFamiliar = new GXBaseCollection<com.projectthani.SdtSDTListadoFamiliarPorPaciente>(com.projectthani.SdtSDTListadoFamiliarPorPaciente.class, "SDTListadoFamiliarPorPaciente", "ProjectThani", remoteHandle);
      scmdbuf = "" ;
      P006Z2_A20PacienteId = new int[1] ;
      P006Z2_A46SGPacienteHijoPacienteId = new int[1] ;
      P006Z2_A235PacienteFamiliarParentesco = new String[] {""} ;
      P006Z2_A45PacienteFamiliarId = new int[1] ;
      A235PacienteFamiliarParentesco = "" ;
      AV10Familiar = new com.projectthani.SdtSDTListadoFamiliarPorPaciente(remoteHandle, context);
      AV15Paciente = new com.projectthani.SdtPaciente(remoteHandle);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcgetlistadofamiliarporpaciente__default(),
         new Object[] {
             new Object[] {
            P006Z2_A20PacienteId, P006Z2_A46SGPacienteHijoPacienteId, P006Z2_A235PacienteFamiliarParentesco, P006Z2_A45PacienteFamiliarId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8PacienteId ;
   private int A20PacienteId ;
   private int A46SGPacienteHijoPacienteId ;
   private int A45PacienteFamiliarId ;
   private String scmdbuf ;
   private String A235PacienteFamiliarParentesco ;
   private GXBaseCollection<com.projectthani.SdtSDTListadoFamiliarPorPaciente>[] aP1 ;
   private IDataStoreProvider pr_default ;
   private int[] P006Z2_A20PacienteId ;
   private int[] P006Z2_A46SGPacienteHijoPacienteId ;
   private String[] P006Z2_A235PacienteFamiliarParentesco ;
   private int[] P006Z2_A45PacienteFamiliarId ;
   private GXBaseCollection<com.projectthani.SdtSDTListadoFamiliarPorPaciente> AV11ListadoFamiliar ;
   private com.projectthani.SdtSDTListadoFamiliarPorPaciente AV10Familiar ;
   private com.projectthani.SdtPaciente AV15Paciente ;
}

final  class prcgetlistadofamiliarporpaciente__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P006Z2", "SELECT [PacienteId], [SGPacienteHijoPacienteId], [PacienteFamiliarParentesco], [PacienteFamiliarId] FROM [PacienteFamiliar] WHERE [PacienteId] = ? ORDER BY [PacienteId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 2);
               ((int[]) buf[3])[0] = rslt.getInt(4);
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

