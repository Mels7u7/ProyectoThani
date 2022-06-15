package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prccountpaciente extends GXProcedure
{
   public prccountpaciente( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prccountpaciente.class ), "" );
   }

   public prccountpaciente( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 )
   {
      prccountpaciente.this.aP1 = new short[] {0};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        short[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             short[] aP1 )
   {
      prccountpaciente.this.AV14ProfesionalId = aP0;
      prccountpaciente.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV15TotalPacientes = (short)(0) ;
      /* Using cursor P00882 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         A21SGCitaDisponibilidadId = P00882_A21SGCitaDisponibilidadId[0] ;
         A20PacienteId = P00882_A20PacienteId[0] ;
         AV8CountPaciente = (com.projectthani.SdtSDTCountPaciente)new com.projectthani.SdtSDTCountPaciente(remoteHandle, context);
         AV8CountPaciente.setgxTv_SdtSDTCountPaciente_Id( A20PacienteId );
         AV12IdsPaciente.add(AV8CountPaciente, 0);
         /* Using cursor P00883 */
         pr_default.execute(1, new Object[] {Integer.valueOf(A21SGCitaDisponibilidadId), Integer.valueOf(AV14ProfesionalId)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A34DisponibilidadId = P00883_A34DisponibilidadId[0] ;
            A139DisponibilidadEstadoCita = P00883_A139DisponibilidadEstadoCita[0] ;
            A31ProfesionalId = P00883_A31ProfesionalId[0] ;
            if ( A31ProfesionalId == AV14ProfesionalId )
            {
               AV9DisponibilidadItem = (com.projectthani.SdtSDTDisponibilidadIds)new com.projectthani.SdtSDTDisponibilidadIds(remoteHandle, context);
               AV9DisponibilidadItem.setgxTv_SdtSDTDisponibilidadIds_Id( A34DisponibilidadId );
               AV11DisponibilidadList.add(AV9DisponibilidadItem, 0);
            }
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(1);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      AV20GXV1 = 1 ;
      while ( AV20GXV1 <= AV12IdsPaciente.size() )
      {
         AV10DisponibilidadItemm = (com.projectthani.SdtSDTCountPaciente)((com.projectthani.SdtSDTCountPaciente)AV12IdsPaciente.elementAt(-1+AV20GXV1));
         /* Using cursor P00884 */
         pr_default.execute(2, new Object[] {Short.valueOf(AV10DisponibilidadItemm.getgxTv_SdtSDTCountPaciente_Iddis()), Integer.valueOf(AV14ProfesionalId)});
         while ( (pr_default.getStatus(2) != 101) )
         {
            A34DisponibilidadId = P00884_A34DisponibilidadId[0] ;
            A139DisponibilidadEstadoCita = P00884_A139DisponibilidadEstadoCita[0] ;
            A31ProfesionalId = P00884_A31ProfesionalId[0] ;
            AV9DisponibilidadItem = (com.projectthani.SdtSDTDisponibilidadIds)new com.projectthani.SdtSDTDisponibilidadIds(remoteHandle, context);
            AV9DisponibilidadItem.setgxTv_SdtSDTDisponibilidadIds_Id( A34DisponibilidadId );
            AV11DisponibilidadList.add(AV9DisponibilidadItem, 0);
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(2);
         AV20GXV1 = (int)(AV20GXV1+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = prccountpaciente.this.AV15TotalPacientes;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      P00882_A21SGCitaDisponibilidadId = new int[1] ;
      P00882_A20PacienteId = new int[1] ;
      AV8CountPaciente = new com.projectthani.SdtSDTCountPaciente(remoteHandle, context);
      AV12IdsPaciente = new GXBaseCollection<com.projectthani.SdtSDTCountPaciente>(com.projectthani.SdtSDTCountPaciente.class, "SDTCountPaciente", "ProjectThani", remoteHandle);
      P00883_A34DisponibilidadId = new int[1] ;
      P00883_A139DisponibilidadEstadoCita = new String[] {""} ;
      P00883_A31ProfesionalId = new int[1] ;
      A139DisponibilidadEstadoCita = "" ;
      AV9DisponibilidadItem = new com.projectthani.SdtSDTDisponibilidadIds(remoteHandle, context);
      AV11DisponibilidadList = new GXBaseCollection<com.projectthani.SdtSDTDisponibilidadIds>(com.projectthani.SdtSDTDisponibilidadIds.class, "SDTDisponibilidadIds", "ProjectThani", remoteHandle);
      AV10DisponibilidadItemm = new com.projectthani.SdtSDTCountPaciente(remoteHandle, context);
      P00884_A34DisponibilidadId = new int[1] ;
      P00884_A139DisponibilidadEstadoCita = new String[] {""} ;
      P00884_A31ProfesionalId = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prccountpaciente__default(),
         new Object[] {
             new Object[] {
            P00882_A21SGCitaDisponibilidadId, P00882_A20PacienteId
            }
            , new Object[] {
            P00883_A34DisponibilidadId, P00883_A139DisponibilidadEstadoCita, P00883_A31ProfesionalId
            }
            , new Object[] {
            P00884_A34DisponibilidadId, P00884_A139DisponibilidadEstadoCita, P00884_A31ProfesionalId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV15TotalPacientes ;
   private short Gx_err ;
   private int AV14ProfesionalId ;
   private int A21SGCitaDisponibilidadId ;
   private int A20PacienteId ;
   private int A34DisponibilidadId ;
   private int A31ProfesionalId ;
   private int AV20GXV1 ;
   private String scmdbuf ;
   private String A139DisponibilidadEstadoCita ;
   private short[] aP1 ;
   private IDataStoreProvider pr_default ;
   private int[] P00882_A21SGCitaDisponibilidadId ;
   private int[] P00882_A20PacienteId ;
   private int[] P00883_A34DisponibilidadId ;
   private String[] P00883_A139DisponibilidadEstadoCita ;
   private int[] P00883_A31ProfesionalId ;
   private int[] P00884_A34DisponibilidadId ;
   private String[] P00884_A139DisponibilidadEstadoCita ;
   private int[] P00884_A31ProfesionalId ;
   private GXBaseCollection<com.projectthani.SdtSDTCountPaciente> AV12IdsPaciente ;
   private GXBaseCollection<com.projectthani.SdtSDTDisponibilidadIds> AV11DisponibilidadList ;
   private com.projectthani.SdtSDTCountPaciente AV8CountPaciente ;
   private com.projectthani.SdtSDTCountPaciente AV10DisponibilidadItemm ;
   private com.projectthani.SdtSDTDisponibilidadIds AV9DisponibilidadItem ;
}

final  class prccountpaciente__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00882", "SELECT DISTINCT [SGCitaDisponibilidadId], [PacienteId] FROM [Cita] ORDER BY [PacienteId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00883", "SELECT [DisponibilidadId], [DisponibilidadEstadoCita], [ProfesionalId] FROM [Disponibilidad] WHERE ([DisponibilidadId] = ?) AND ([ProfesionalId] = ?) AND ([DisponibilidadEstadoCita] = 'O') ORDER BY [DisponibilidadId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P00884", "SELECT [DisponibilidadId], [DisponibilidadEstadoCita], [ProfesionalId] FROM [Disponibilidad] WHERE ([DisponibilidadId] = ?) AND ([ProfesionalId] = ?) AND ([DisponibilidadEstadoCita] = 'O') ORDER BY [DisponibilidadId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
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
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               return;
      }
   }

}

