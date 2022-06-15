package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prccountcitas extends GXProcedure
{
   public prccountcitas( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prccountcitas.class ), "" );
   }

   public prccountcitas( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 )
   {
      prccountcitas.this.aP1 = new short[] {0};
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
      prccountcitas.this.AV8ProfesionalId = aP0;
      prccountcitas.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9TotalCita = (short)(0) ;
      /* Using cursor P00872 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8ProfesionalId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A31ProfesionalId = P00872_A31ProfesionalId[0] ;
         A34DisponibilidadId = P00872_A34DisponibilidadId[0] ;
         AV10DisponibilidadId = A34DisponibilidadId ;
         /* Optimized group. */
         /* Using cursor P00873 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV10DisponibilidadId)});
         cV9TotalCita = P00873_AV9TotalCita[0] ;
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
      this.aP1[0] = prccountcitas.this.AV9TotalCita;
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
      P00872_A31ProfesionalId = new int[1] ;
      P00872_A34DisponibilidadId = new int[1] ;
      P00873_AV9TotalCita = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prccountcitas__default(),
         new Object[] {
             new Object[] {
            P00872_A31ProfesionalId, P00872_A34DisponibilidadId
            }
            , new Object[] {
            P00873_AV9TotalCita
            }
         }
      );
      /* GeneXus formulas. */
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
   private short[] aP1 ;
   private IDataStoreProvider pr_default ;
   private int[] P00872_A31ProfesionalId ;
   private int[] P00872_A34DisponibilidadId ;
   private short[] P00873_AV9TotalCita ;
}

final  class prccountcitas__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00872", "SELECT [ProfesionalId], [DisponibilidadId] FROM [Disponibilidad] WHERE [ProfesionalId] = ? ORDER BY [ProfesionalId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00873", "SELECT COUNT(*) FROM [Cita] WHERE [SGCitaDisponibilidadId] = ? ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

