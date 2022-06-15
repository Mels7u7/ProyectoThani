package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcvalidardisponibilidadcita extends GXProcedure
{
   public prcvalidardisponibilidadcita( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcvalidardisponibilidadcita.class ), "" );
   }

   public prcvalidardisponibilidadcita( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 )
   {
      prcvalidardisponibilidadcita.this.aP1 = new boolean[] {false};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        boolean[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             boolean[] aP1 )
   {
      prcvalidardisponibilidadcita.this.AV8DisponibilidadId = aP0;
      prcvalidardisponibilidadcita.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9isOpen = true ;
      /* Using cursor P006O2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8DisponibilidadId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A21SGCitaDisponibilidadId = P006O2_A21SGCitaDisponibilidadId[0] ;
         A19CitaId = P006O2_A19CitaId[0] ;
         AV9isOpen = false ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = prcvalidardisponibilidadcita.this.AV9isOpen;
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
      P006O2_A21SGCitaDisponibilidadId = new int[1] ;
      P006O2_A19CitaId = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcvalidardisponibilidadcita__default(),
         new Object[] {
             new Object[] {
            P006O2_A21SGCitaDisponibilidadId, P006O2_A19CitaId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8DisponibilidadId ;
   private int A21SGCitaDisponibilidadId ;
   private int A19CitaId ;
   private String scmdbuf ;
   private boolean AV9isOpen ;
   private boolean[] aP1 ;
   private IDataStoreProvider pr_default ;
   private int[] P006O2_A21SGCitaDisponibilidadId ;
   private int[] P006O2_A19CitaId ;
}

final  class prcvalidardisponibilidadcita__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P006O2", "SELECT [SGCitaDisponibilidadId], [CitaId] FROM [Cita] WHERE [SGCitaDisponibilidadId] = ? ORDER BY [SGCitaDisponibilidadId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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

