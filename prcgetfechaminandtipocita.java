package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcgetfechaminandtipocita extends GXProcedure
{
   public prcgetfechaminandtipocita( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcgetfechaminandtipocita.class ), "" );
   }

   public prcgetfechaminandtipocita( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             java.util.Date[] aP1 )
   {
      prcgetfechaminandtipocita.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        java.util.Date[] aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             java.util.Date[] aP1 ,
                             String[] aP2 )
   {
      prcgetfechaminandtipocita.this.AV12ProfesionalId = aP0;
      prcgetfechaminandtipocita.this.aP1 = aP1;
      prcgetfechaminandtipocita.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P005A3 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV12ProfesionalId), Gx_date});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A34DisponibilidadId = P005A3_A34DisponibilidadId[0] ;
         A35SGSedeDisponibilidadSedeId = P005A3_A35SGSedeDisponibilidadSedeId[0] ;
         n35SGSedeDisponibilidadSedeId = P005A3_n35SGSedeDisponibilidadSedeId[0] ;
         A67DisponibilidadFecha = P005A3_A67DisponibilidadFecha[0] ;
         n67DisponibilidadFecha = P005A3_n67DisponibilidadFecha[0] ;
         A31ProfesionalId = P005A3_A31ProfesionalId[0] ;
         A40000GXC1 = P005A3_A40000GXC1[0] ;
         n40000GXC1 = P005A3_n40000GXC1[0] ;
         A40000GXC1 = P005A3_A40000GXC1[0] ;
         n40000GXC1 = P005A3_n40000GXC1[0] ;
         AV8DisponibilidadFecha = A40000GXC1 ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      /* Using cursor P005A4 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV12ProfesionalId), Gx_date});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A67DisponibilidadFecha = P005A4_A67DisponibilidadFecha[0] ;
         n67DisponibilidadFecha = P005A4_n67DisponibilidadFecha[0] ;
         A31ProfesionalId = P005A4_A31ProfesionalId[0] ;
         A298DisponibilidadTipoCita = P005A4_A298DisponibilidadTipoCita[0] ;
         AV9DispoCitas += com.projectthani.gxdomaintipocita.getDescription(httpContext,(String)A298DisponibilidadTipoCita) + " / " ;
         pr_default.readNext(1);
      }
      pr_default.close(1);
      AV10DisponibilidadTipoCitas = GXutil.substring( AV9DispoCitas, 1, GXutil.len( AV9DispoCitas)-1) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = prcgetfechaminandtipocita.this.AV8DisponibilidadFecha;
      this.aP2[0] = prcgetfechaminandtipocita.this.AV10DisponibilidadTipoCitas;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8DisponibilidadFecha = GXutil.nullDate() ;
      AV10DisponibilidadTipoCitas = "" ;
      scmdbuf = "" ;
      Gx_date = GXutil.nullDate() ;
      P005A3_A34DisponibilidadId = new int[1] ;
      P005A3_A35SGSedeDisponibilidadSedeId = new short[1] ;
      P005A3_n35SGSedeDisponibilidadSedeId = new boolean[] {false} ;
      P005A3_A67DisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P005A3_n67DisponibilidadFecha = new boolean[] {false} ;
      P005A3_A31ProfesionalId = new int[1] ;
      P005A3_A40000GXC1 = new java.util.Date[] {GXutil.nullDate()} ;
      P005A3_n40000GXC1 = new boolean[] {false} ;
      A67DisponibilidadFecha = GXutil.nullDate() ;
      A40000GXC1 = GXutil.nullDate() ;
      P005A4_A67DisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P005A4_n67DisponibilidadFecha = new boolean[] {false} ;
      P005A4_A31ProfesionalId = new int[1] ;
      P005A4_A298DisponibilidadTipoCita = new String[] {""} ;
      A298DisponibilidadTipoCita = "" ;
      AV9DispoCitas = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcgetfechaminandtipocita__default(),
         new Object[] {
             new Object[] {
            P005A3_A34DisponibilidadId, P005A3_A35SGSedeDisponibilidadSedeId, P005A3_n35SGSedeDisponibilidadSedeId, P005A3_A67DisponibilidadFecha, P005A3_n67DisponibilidadFecha, P005A3_A31ProfesionalId, P005A3_A40000GXC1, P005A3_n40000GXC1
            }
            , new Object[] {
            P005A4_A67DisponibilidadFecha, P005A4_n67DisponibilidadFecha, P005A4_A31ProfesionalId, P005A4_A298DisponibilidadTipoCita
            }
         }
      );
      Gx_date = GXutil.today( ) ;
      /* GeneXus formulas. */
      Gx_date = GXutil.today( ) ;
      Gx_err = (short)(0) ;
   }

   private short A35SGSedeDisponibilidadSedeId ;
   private short Gx_err ;
   private int AV12ProfesionalId ;
   private int A34DisponibilidadId ;
   private int A31ProfesionalId ;
   private String scmdbuf ;
   private String A298DisponibilidadTipoCita ;
   private java.util.Date AV8DisponibilidadFecha ;
   private java.util.Date Gx_date ;
   private java.util.Date A67DisponibilidadFecha ;
   private java.util.Date A40000GXC1 ;
   private boolean n35SGSedeDisponibilidadSedeId ;
   private boolean n67DisponibilidadFecha ;
   private boolean n40000GXC1 ;
   private String AV10DisponibilidadTipoCitas ;
   private String AV9DispoCitas ;
   private String[] aP2 ;
   private java.util.Date[] aP1 ;
   private IDataStoreProvider pr_default ;
   private int[] P005A3_A34DisponibilidadId ;
   private short[] P005A3_A35SGSedeDisponibilidadSedeId ;
   private boolean[] P005A3_n35SGSedeDisponibilidadSedeId ;
   private java.util.Date[] P005A3_A67DisponibilidadFecha ;
   private boolean[] P005A3_n67DisponibilidadFecha ;
   private int[] P005A3_A31ProfesionalId ;
   private java.util.Date[] P005A3_A40000GXC1 ;
   private boolean[] P005A3_n40000GXC1 ;
   private java.util.Date[] P005A4_A67DisponibilidadFecha ;
   private boolean[] P005A4_n67DisponibilidadFecha ;
   private int[] P005A4_A31ProfesionalId ;
   private String[] P005A4_A298DisponibilidadTipoCita ;
}

final  class prcgetfechaminandtipocita__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P005A3", "SELECT T1.[DisponibilidadId], T1.[SGSedeDisponibilidadSedeId], T1.[DisponibilidadFecha], T1.[ProfesionalId], COALESCE( T2.[GXC1], convert( DATETIME, '17530101', 112 )) AS GXC1 FROM ([Disponibilidad] T1 LEFT JOIN (SELECT MIN([DisponibilidadFecha]) AS GXC1, [DisponibilidadId], [SGSedeDisponibilidadSedeId] FROM [Disponibilidad] GROUP BY [DisponibilidadId], [SGSedeDisponibilidadSedeId] ) T2 ON T2.[DisponibilidadId] = T1.[DisponibilidadId] AND T2.[SGSedeDisponibilidadSedeId] = T1.[SGSedeDisponibilidadSedeId]) WHERE (T1.[ProfesionalId] = ?) AND (T1.[DisponibilidadFecha] >= ?) ORDER BY T1.[ProfesionalId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P005A4", "SELECT DISTINCT NULL AS [DisponibilidadFecha], NULL AS [ProfesionalId], [DisponibilidadTipoCita] FROM ( SELECT TOP(100) PERCENT [DisponibilidadFecha], [ProfesionalId], [DisponibilidadTipoCita] FROM [Disponibilidad] WHERE ([ProfesionalId] = ?) AND ([DisponibilidadFecha] >= ?) ORDER BY [ProfesionalId]) DistinctT ORDER BY [ProfesionalId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((int[]) buf[5])[0] = rslt.getInt(4);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               return;
            case 1 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((int[]) buf[2])[0] = rslt.getInt(2);
               ((String[]) buf[3])[0] = rslt.getString(3, 1);
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
               stmt.setDate(2, (java.util.Date)parms[1]);
               return;
      }
   }

}

