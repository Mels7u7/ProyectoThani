package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class verificarhorarioduplicado extends GXProcedure
{
   public verificarhorarioduplicado( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( verificarhorarioduplicado.class ), "" );
   }

   public verificarhorarioduplicado( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              java.util.Date aP2 ,
                              String aP3 )
   {
      verificarhorarioduplicado.this.aP4 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        java.util.Date aP2 ,
                        String aP3 ,
                        boolean[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             java.util.Date aP2 ,
                             String aP3 ,
                             boolean[] aP4 )
   {
      verificarhorarioduplicado.this.AV13ProfesionalId = aP0;
      verificarhorarioduplicado.this.AV12EspecialidadId = aP1;
      verificarhorarioduplicado.this.AV9DisponibilidadFecha = aP2;
      verificarhorarioduplicado.this.AV10DisponibilidadHoraInicio = aP3;
      verificarhorarioduplicado.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV14Val = false ;
      AV11DisponibilidadHoraInicio2 = GXutil.resetTime( localUtil.ctod( AV10DisponibilidadHoraInicio, 3) );
      /* Using cursor P00672 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13ProfesionalId), AV9DisponibilidadFecha});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A135DisponibilidadHoraFin = P00672_A135DisponibilidadHoraFin[0] ;
         n135DisponibilidadHoraFin = P00672_n135DisponibilidadHoraFin[0] ;
         A69DisponibilidadHoraInicio = P00672_A69DisponibilidadHoraInicio[0] ;
         n69DisponibilidadHoraInicio = P00672_n69DisponibilidadHoraInicio[0] ;
         A67DisponibilidadFecha = P00672_A67DisponibilidadFecha[0] ;
         n67DisponibilidadFecha = P00672_n67DisponibilidadFecha[0] ;
         A31ProfesionalId = P00672_A31ProfesionalId[0] ;
         A136DisponibilidadEstado = P00672_A136DisponibilidadEstado[0] ;
         A34DisponibilidadId = P00672_A34DisponibilidadId[0] ;
         if ( ( GXutil.strcmp(localUtil.ttoc( AV11DisponibilidadHoraInicio2, 0, 5, 0, 3, "/", ":", " "), localUtil.ttoc( A69DisponibilidadHoraInicio, 0, 5, 0, 3, "/", ":", " ")) >= 0 ) && ( GXutil.strcmp(localUtil.ttoc( AV11DisponibilidadHoraInicio2, 0, 5, 0, 3, "/", ":", " "), localUtil.ttoc( A135DisponibilidadHoraFin, 0, 5, 0, 3, "/", ":", " ")) <= 0 ) )
         {
            AV8disponibilidadId = A34DisponibilidadId ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV8disponibilidadId > 0 )
      {
         AV14Val = true ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = verificarhorarioduplicado.this.AV14Val;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11DisponibilidadHoraInicio2 = GXutil.resetTime( GXutil.nullDate() );
      scmdbuf = "" ;
      P00672_A135DisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      P00672_n135DisponibilidadHoraFin = new boolean[] {false} ;
      P00672_A69DisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      P00672_n69DisponibilidadHoraInicio = new boolean[] {false} ;
      P00672_A67DisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P00672_n67DisponibilidadFecha = new boolean[] {false} ;
      P00672_A31ProfesionalId = new int[1] ;
      P00672_A136DisponibilidadEstado = new String[] {""} ;
      P00672_A34DisponibilidadId = new int[1] ;
      A135DisponibilidadHoraFin = GXutil.resetTime( GXutil.nullDate() );
      A69DisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
      A67DisponibilidadFecha = GXutil.nullDate() ;
      A136DisponibilidadEstado = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.verificarhorarioduplicado__default(),
         new Object[] {
             new Object[] {
            P00672_A135DisponibilidadHoraFin, P00672_n135DisponibilidadHoraFin, P00672_A69DisponibilidadHoraInicio, P00672_n69DisponibilidadHoraInicio, P00672_A67DisponibilidadFecha, P00672_n67DisponibilidadFecha, P00672_A31ProfesionalId, P00672_A136DisponibilidadEstado, P00672_A34DisponibilidadId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV12EspecialidadId ;
   private short Gx_err ;
   private int AV13ProfesionalId ;
   private int A31ProfesionalId ;
   private int A34DisponibilidadId ;
   private int AV8disponibilidadId ;
   private String scmdbuf ;
   private String A136DisponibilidadEstado ;
   private java.util.Date AV11DisponibilidadHoraInicio2 ;
   private java.util.Date A135DisponibilidadHoraFin ;
   private java.util.Date A69DisponibilidadHoraInicio ;
   private java.util.Date AV9DisponibilidadFecha ;
   private java.util.Date A67DisponibilidadFecha ;
   private boolean AV14Val ;
   private boolean n135DisponibilidadHoraFin ;
   private boolean n69DisponibilidadHoraInicio ;
   private boolean n67DisponibilidadFecha ;
   private String AV10DisponibilidadHoraInicio ;
   private boolean[] aP4 ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] P00672_A135DisponibilidadHoraFin ;
   private boolean[] P00672_n135DisponibilidadHoraFin ;
   private java.util.Date[] P00672_A69DisponibilidadHoraInicio ;
   private boolean[] P00672_n69DisponibilidadHoraInicio ;
   private java.util.Date[] P00672_A67DisponibilidadFecha ;
   private boolean[] P00672_n67DisponibilidadFecha ;
   private int[] P00672_A31ProfesionalId ;
   private String[] P00672_A136DisponibilidadEstado ;
   private int[] P00672_A34DisponibilidadId ;
}

final  class verificarhorarioduplicado__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00672", "SELECT [DisponibilidadHoraFin], [DisponibilidadHoraInicio], [DisponibilidadFecha], [ProfesionalId], [DisponibilidadEstado], [DisponibilidadId] FROM [Disponibilidad] WHERE ([ProfesionalId] = ?) AND ([DisponibilidadEstado] = 'A') AND ([DisponibilidadFecha] = ?) ORDER BY [ProfesionalId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.util.Date[]) buf[0])[0] = GXutil.resetDate(rslt.getGXDateTime(1));
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[2])[0] = GXutil.resetDate(rslt.getGXDateTime(2));
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(3);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((int[]) buf[6])[0] = rslt.getInt(4);
               ((String[]) buf[7])[0] = rslt.getString(5, 1);
               ((int[]) buf[8])[0] = rslt.getInt(6);
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
      }
   }

}

