package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcgetnombreuser extends GXProcedure
{
   public prcgetnombreuser( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcgetnombreuser.class ), "" );
   }

   public prcgetnombreuser( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             short aP1 )
   {
      prcgetnombreuser.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( String aP0 ,
                        short aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( String aP0 ,
                             short aP1 ,
                             String[] aP2 )
   {
      prcgetnombreuser.this.AV13SecUserName = aP0;
      prcgetnombreuser.this.AV11SecRoleId = aP1;
      prcgetnombreuser.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P002L3 */
      pr_default.execute(0, new Object[] {AV13SecUserName});
      if ( (pr_default.getStatus(0) != 101) )
      {
         A40000ProfesionalId = P002L3_A40000ProfesionalId[0] ;
         n40000ProfesionalId = P002L3_n40000ProfesionalId[0] ;
      }
      else
      {
         A40000ProfesionalId = 0 ;
         n40000ProfesionalId = false ;
      }
      pr_default.close(0);
      /* Using cursor P002L5 */
      pr_default.execute(1, new Object[] {AV13SecUserName});
      if ( (pr_default.getStatus(1) != 101) )
      {
         A40001PacienteId = P002L5_A40001PacienteId[0] ;
         n40001PacienteId = P002L5_n40001PacienteId[0] ;
      }
      else
      {
         A40001PacienteId = 0 ;
         n40001PacienteId = false ;
      }
      pr_default.close(1);
      AV8FullName = "Usuario desconocido" ;
      if ( AV11SecRoleId == 2 )
      {
         AV10ProfesionalId = A40000ProfesionalId ;
         AV9Profesional.Load(AV10ProfesionalId);
         AV8FullName = AV9Profesional.getgxTv_SdtProfesional_Profesionalnrodocumento() + " -  " + AV9Profesional.getgxTv_SdtProfesional_Profesionalnombrecompleto2() ;
      }
      else
      {
         if ( AV11SecRoleId == 4 )
         {
            AV14PacienteId = A40001PacienteId ;
            AV15Paciente.Load(AV14PacienteId);
            AV8FullName = AV15Paciente.getgxTv_SdtPaciente_Pacientenrodocumento() + " - " + AV15Paciente.getgxTv_SdtPaciente_Pacienteapellidopaterno() + " " + AV15Paciente.getgxTv_SdtPaciente_Pacienteapellidomaterno() + ", " + AV15Paciente.getgxTv_SdtPaciente_Pacientenombres() ;
         }
         else
         {
            AV8FullName = AV13SecUserName ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = prcgetnombreuser.this.AV8FullName;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8FullName = "" ;
      scmdbuf = "" ;
      P002L3_A40000ProfesionalId = new int[1] ;
      P002L3_n40000ProfesionalId = new boolean[] {false} ;
      P002L5_A40001PacienteId = new int[1] ;
      P002L5_n40001PacienteId = new boolean[] {false} ;
      AV9Profesional = new com.projectthani.SdtProfesional(remoteHandle);
      AV15Paciente = new com.projectthani.SdtPaciente(remoteHandle);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcgetnombreuser__default(),
         new Object[] {
             new Object[] {
            P002L3_A40000ProfesionalId, P002L3_n40000ProfesionalId
            }
            , new Object[] {
            P002L5_A40001PacienteId, P002L5_n40001PacienteId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11SecRoleId ;
   private short Gx_err ;
   private int A40000ProfesionalId ;
   private int A40001PacienteId ;
   private int AV10ProfesionalId ;
   private int AV14PacienteId ;
   private String scmdbuf ;
   private boolean n40000ProfesionalId ;
   private boolean n40001PacienteId ;
   private String AV13SecUserName ;
   private String AV8FullName ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private int[] P002L3_A40000ProfesionalId ;
   private boolean[] P002L3_n40000ProfesionalId ;
   private int[] P002L5_A40001PacienteId ;
   private boolean[] P002L5_n40001PacienteId ;
   private com.projectthani.SdtProfesional AV9Profesional ;
   private com.projectthani.SdtPaciente AV15Paciente ;
}

final  class prcgetnombreuser__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P002L3", "SELECT COALESCE( T1.[ProfesionalId], 0) AS ProfesionalId FROM (SELECT MIN([ProfesionalId]) AS ProfesionalId FROM [Profesional] WHERE RTRIM(LTRIM([ProfesionalNroDocumento])) = RTRIM(LTRIM(?)) ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002L5", "SELECT COALESCE( T1.[PacienteId], 0) AS PacienteId FROM (SELECT MIN([PacienteId]) AS PacienteId FROM [Paciente] WHERE RTRIM(LTRIM([PacienteNroDocumento])) = RTRIM(LTRIM(?)) ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
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
               stmt.setVarchar(1, (String)parms[0], 100);
               return;
            case 1 :
               stmt.setVarchar(1, (String)parms[0], 100);
               return;
      }
   }

}

