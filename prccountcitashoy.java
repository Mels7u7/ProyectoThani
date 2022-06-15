package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prccountcitashoy extends GXProcedure
{
   public prccountcitashoy( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prccountcitashoy.class ), "" );
   }

   public prccountcitashoy( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 )
   {
      prccountcitashoy.this.aP1 = new short[] {0};
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
      prccountcitashoy.this.AV8ProfesionalId = aP0;
      prccountcitashoy.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9TotalCita = (short)(0) ;
      /* Using cursor P008B2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8ProfesionalId), Gx_date});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A139DisponibilidadEstadoCita = P008B2_A139DisponibilidadEstadoCita[0] ;
         A67DisponibilidadFecha = P008B2_A67DisponibilidadFecha[0] ;
         n67DisponibilidadFecha = P008B2_n67DisponibilidadFecha[0] ;
         A31ProfesionalId = P008B2_A31ProfesionalId[0] ;
         A34DisponibilidadId = P008B2_A34DisponibilidadId[0] ;
         AV10DisponibilidadId = A34DisponibilidadId ;
         /* Optimized group. */
         /* Using cursor P008B3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV10DisponibilidadId)});
         cV9TotalCita = P008B3_AV9TotalCita[0] ;
         pr_default.close(1);
         AV9TotalCita = (short)(AV9TotalCita+cV9TotalCita*1) ;
         /* End optimized group. */
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = prccountcitashoy.this.AV9TotalCita;
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
      Gx_date = GXutil.nullDate() ;
      P008B2_A139DisponibilidadEstadoCita = new String[] {""} ;
      P008B2_A67DisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P008B2_n67DisponibilidadFecha = new boolean[] {false} ;
      P008B2_A31ProfesionalId = new int[1] ;
      P008B2_A34DisponibilidadId = new int[1] ;
      A139DisponibilidadEstadoCita = "" ;
      A67DisponibilidadFecha = GXutil.nullDate() ;
      P008B3_AV9TotalCita = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prccountcitashoy__default(),
         new Object[] {
             new Object[] {
            P008B2_A139DisponibilidadEstadoCita, P008B2_A67DisponibilidadFecha, P008B2_n67DisponibilidadFecha, P008B2_A31ProfesionalId, P008B2_A34DisponibilidadId
            }
            , new Object[] {
            P008B3_AV9TotalCita
            }
         }
      );
      Gx_date = GXutil.today( ) ;
      /* GeneXus formulas. */
      Gx_date = GXutil.today( ) ;
      Gx_err = (short)(0) ;
   }

   private short AV9TotalCita ;
   private short cV9TotalCita ;
   private short Gx_err ;
   private int AV8ProfesionalId ;
   private int A31ProfesionalId ;
   private int A34DisponibilidadId ;
   private int AV10DisponibilidadId ;
   private String scmdbuf ;
   private java.util.Date Gx_date ;
   private java.util.Date A67DisponibilidadFecha ;
   private boolean n67DisponibilidadFecha ;
   private String A139DisponibilidadEstadoCita ;
   private short[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P008B2_A139DisponibilidadEstadoCita ;
   private java.util.Date[] P008B2_A67DisponibilidadFecha ;
   private boolean[] P008B2_n67DisponibilidadFecha ;
   private int[] P008B2_A31ProfesionalId ;
   private int[] P008B2_A34DisponibilidadId ;
   private short[] P008B3_AV9TotalCita ;
}

final  class prccountcitashoy__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P008B2", "SELECT [DisponibilidadEstadoCita], [DisponibilidadFecha], [ProfesionalId], [DisponibilidadId] FROM [Disponibilidad] WHERE ([ProfesionalId] = ?) AND ([DisponibilidadFecha] = ?) AND ([DisponibilidadEstadoCita] = 'O') ORDER BY [ProfesionalId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P008B3", "SELECT COUNT(*) FROM ( SELECT [PacienteId] FROM [Cita] WHERE ([SGCitaDisponibilidadId] = ?) AND ([CitaEstadoCita] = 'R') GROUP BY [PacienteId]) GroupByT ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((int[]) buf[4])[0] = rslt.getInt(4);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
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
               stmt.setDate(2, (java.util.Date)parms[1]);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

