package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcgetlistadopacientefamiliarcombobox extends GXProcedure
{
   public prcgetlistadopacientefamiliarcombobox( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcgetlistadopacientefamiliarcombobox.class ), "" );
   }

   public prcgetlistadopacientefamiliarcombobox( int remoteHandle ,
                                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.projectthani.SdtSDTListadoPacienteFamiliarComboBox> executeUdp( int aP0 )
   {
      prcgetlistadopacientefamiliarcombobox.this.aP1 = new GXBaseCollection[] {new GXBaseCollection<com.projectthani.SdtSDTListadoPacienteFamiliarComboBox>()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        GXBaseCollection<com.projectthani.SdtSDTListadoPacienteFamiliarComboBox>[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             GXBaseCollection<com.projectthani.SdtSDTListadoPacienteFamiliarComboBox>[] aP1 )
   {
      prcgetlistadopacientefamiliarcombobox.this.AV11PacienteId = aP0;
      prcgetlistadopacientefamiliarcombobox.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P005O2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11PacienteId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A20PacienteId = P005O2_A20PacienteId[0] ;
         A46SGPacienteHijoPacienteId = P005O2_A46SGPacienteHijoPacienteId[0] ;
         A45PacienteFamiliarId = P005O2_A45PacienteFamiliarId[0] ;
         AV9Familiar = (com.projectthani.SdtSDTListadoPacienteFamiliarComboBox)new com.projectthani.SdtSDTListadoPacienteFamiliarComboBox(remoteHandle, context);
         AV8Paciente.Load(A46SGPacienteHijoPacienteId);
         AV9Familiar.setgxTv_SdtSDTListadoPacienteFamiliarComboBox_Nombresapellidos( AV8Paciente.getgxTv_SdtPaciente_Pacientenombres()+" "+AV8Paciente.getgxTv_SdtPaciente_Pacienteapellidopaterno()+" "+AV8Paciente.getgxTv_SdtPaciente_Pacienteapellidomaterno() );
         AV9Familiar.setgxTv_SdtSDTListadoPacienteFamiliarComboBox_Pacientefamiliarid( A46SGPacienteHijoPacienteId );
         AV10ListadoFamiliar.add(AV9Familiar, 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = prcgetlistadopacientefamiliarcombobox.this.AV10ListadoFamiliar;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10ListadoFamiliar = new GXBaseCollection<com.projectthani.SdtSDTListadoPacienteFamiliarComboBox>(com.projectthani.SdtSDTListadoPacienteFamiliarComboBox.class, "SDTListadoPacienteFamiliarComboBox", "ProjectThani", remoteHandle);
      scmdbuf = "" ;
      P005O2_A20PacienteId = new int[1] ;
      P005O2_A46SGPacienteHijoPacienteId = new int[1] ;
      P005O2_A45PacienteFamiliarId = new int[1] ;
      AV9Familiar = new com.projectthani.SdtSDTListadoPacienteFamiliarComboBox(remoteHandle, context);
      AV8Paciente = new com.projectthani.SdtPaciente(remoteHandle);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcgetlistadopacientefamiliarcombobox__default(),
         new Object[] {
             new Object[] {
            P005O2_A20PacienteId, P005O2_A46SGPacienteHijoPacienteId, P005O2_A45PacienteFamiliarId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV11PacienteId ;
   private int A20PacienteId ;
   private int A46SGPacienteHijoPacienteId ;
   private int A45PacienteFamiliarId ;
   private String scmdbuf ;
   private GXBaseCollection<com.projectthani.SdtSDTListadoPacienteFamiliarComboBox>[] aP1 ;
   private IDataStoreProvider pr_default ;
   private int[] P005O2_A20PacienteId ;
   private int[] P005O2_A46SGPacienteHijoPacienteId ;
   private int[] P005O2_A45PacienteFamiliarId ;
   private GXBaseCollection<com.projectthani.SdtSDTListadoPacienteFamiliarComboBox> AV10ListadoFamiliar ;
   private com.projectthani.SdtPaciente AV8Paciente ;
   private com.projectthani.SdtSDTListadoPacienteFamiliarComboBox AV9Familiar ;
}

final  class prcgetlistadopacientefamiliarcombobox__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P005O2", "SELECT [PacienteId], [SGPacienteHijoPacienteId], [PacienteFamiliarId] FROM [PacienteFamiliar] WHERE [PacienteId] = ? ORDER BY [PacienteId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[2])[0] = rslt.getInt(3);
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

