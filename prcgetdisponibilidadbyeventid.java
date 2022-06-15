package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcgetdisponibilidadbyeventid extends GXProcedure
{
   public prcgetdisponibilidadbyeventid( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcgetdisponibilidadbyeventid.class ), "" );
   }

   public prcgetdisponibilidadbyeventid( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             int[] aP1 ,
                             int[] aP2 )
   {
      prcgetdisponibilidadbyeventid.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( String aP0 ,
                        int[] aP1 ,
                        int[] aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( String aP0 ,
                             int[] aP1 ,
                             int[] aP2 ,
                             String[] aP3 )
   {
      prcgetdisponibilidadbyeventid.this.AV8EventId = aP0;
      prcgetdisponibilidadbyeventid.this.aP1 = aP1;
      prcgetdisponibilidadbyeventid.this.aP2 = aP2;
      prcgetdisponibilidadbyeventid.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00623 */
      pr_default.execute(0, new Object[] {AV8EventId});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A133EventId = P00623_A133EventId[0] ;
         A34DisponibilidadId = P00623_A34DisponibilidadId[0] ;
         A138DCitaId = P00623_A138DCitaId[0] ;
         n138DCitaId = P00623_n138DCitaId[0] ;
         A138DCitaId = P00623_A138DCitaId[0] ;
         n138DCitaId = P00623_n138DCitaId[0] ;
         AV11DisponibilidadId = A34DisponibilidadId ;
         AV9CitaId = A138DCitaId ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      /* Using cursor P00624 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV9CitaId)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A19CitaId = P00624_A19CitaId[0] ;
         A89CitaEstadoCita = P00624_A89CitaEstadoCita[0] ;
         n89CitaEstadoCita = P00624_n89CitaEstadoCita[0] ;
         AV10CitaEstadoCita = A89CitaEstadoCita ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(1);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = prcgetdisponibilidadbyeventid.this.AV11DisponibilidadId;
      this.aP2[0] = prcgetdisponibilidadbyeventid.this.AV9CitaId;
      this.aP3[0] = prcgetdisponibilidadbyeventid.this.AV10CitaEstadoCita;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10CitaEstadoCita = "" ;
      scmdbuf = "" ;
      P00623_A133EventId = new String[] {""} ;
      P00623_A34DisponibilidadId = new int[1] ;
      P00623_A138DCitaId = new int[1] ;
      P00623_n138DCitaId = new boolean[] {false} ;
      A133EventId = "" ;
      P00624_A19CitaId = new int[1] ;
      P00624_A89CitaEstadoCita = new String[] {""} ;
      P00624_n89CitaEstadoCita = new boolean[] {false} ;
      A89CitaEstadoCita = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcgetdisponibilidadbyeventid__default(),
         new Object[] {
             new Object[] {
            P00623_A133EventId, P00623_A34DisponibilidadId, P00623_A138DCitaId, P00623_n138DCitaId
            }
            , new Object[] {
            P00624_A19CitaId, P00624_A89CitaEstadoCita, P00624_n89CitaEstadoCita
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV11DisponibilidadId ;
   private int AV9CitaId ;
   private int A34DisponibilidadId ;
   private int A138DCitaId ;
   private int A19CitaId ;
   private String AV8EventId ;
   private String AV10CitaEstadoCita ;
   private String scmdbuf ;
   private String A133EventId ;
   private String A89CitaEstadoCita ;
   private boolean n138DCitaId ;
   private boolean n89CitaEstadoCita ;
   private String[] aP3 ;
   private int[] aP1 ;
   private int[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P00623_A133EventId ;
   private int[] P00623_A34DisponibilidadId ;
   private int[] P00623_A138DCitaId ;
   private boolean[] P00623_n138DCitaId ;
   private int[] P00624_A19CitaId ;
   private String[] P00624_A89CitaEstadoCita ;
   private boolean[] P00624_n89CitaEstadoCita ;
}

final  class prcgetdisponibilidadbyeventid__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00623", "SELECT T1.[EventId], T1.[DisponibilidadId], COALESCE( T2.[DCitaId], 0) AS DCitaId FROM ([Disponibilidad] T1 LEFT JOIN (SELECT MIN(T3.[CitaId]) AS DCitaId, T3.[SGCitaDisponibilidadId] FROM [Cita] T3,  [Disponibilidad] T4 WHERE (T3.[SGCitaDisponibilidadId] = T4.[DisponibilidadId]) AND (T3.[CitaEstado] = 'A') GROUP BY T3.[SGCitaDisponibilidadId] ) T2 ON T2.[SGCitaDisponibilidadId] = T1.[DisponibilidadId]) WHERE T1.[EventId] = ? ORDER BY T1.[DisponibilidadId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00624", "SELECT [CitaId], [CitaEstadoCita] FROM [Cita] WHERE [CitaId] = ? ORDER BY [CitaId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
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
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

