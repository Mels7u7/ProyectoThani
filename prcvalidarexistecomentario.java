package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcvalidarexistecomentario extends GXProcedure
{
   public prcvalidarexistecomentario( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcvalidarexistecomentario.class ), "" );
   }

   public prcvalidarexistecomentario( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              int aP1 ,
                              int aP2 )
   {
      prcvalidarexistecomentario.this.aP3 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        int aP1 ,
                        int aP2 ,
                        boolean[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             int aP1 ,
                             int aP2 ,
                             boolean[] aP3 )
   {
      prcvalidarexistecomentario.this.AV12ProfesionalId = aP0;
      prcvalidarexistecomentario.this.AV11PacienteId = aP1;
      prcvalidarexistecomentario.this.AV13CitaId = aP2;
      prcvalidarexistecomentario.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00823 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV12ProfesionalId), Integer.valueOf(AV11PacienteId), Integer.valueOf(AV13CitaId)});
      if ( (pr_default.getStatus(0) != 101) )
      {
         A40000ComentarioProfesionalId = P00823_A40000ComentarioProfesionalId[0] ;
         n40000ComentarioProfesionalId = P00823_n40000ComentarioProfesionalId[0] ;
      }
      else
      {
         A40000ComentarioProfesionalId = 0 ;
         n40000ComentarioProfesionalId = false ;
      }
      pr_default.close(0);
      AV10ValId = A40000ComentarioProfesionalId ;
      if ( AV10ValId > 0 )
      {
         AV9Val = true ;
      }
      else
      {
         AV9Val = false ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = prcvalidarexistecomentario.this.AV9Val;
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
      P00823_A40000ComentarioProfesionalId = new int[1] ;
      P00823_n40000ComentarioProfesionalId = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcvalidarexistecomentario__default(),
         new Object[] {
             new Object[] {
            P00823_A40000ComentarioProfesionalId, P00823_n40000ComentarioProfesionalId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV12ProfesionalId ;
   private int AV11PacienteId ;
   private int AV13CitaId ;
   private int A40000ComentarioProfesionalId ;
   private int AV10ValId ;
   private String scmdbuf ;
   private boolean AV9Val ;
   private boolean n40000ComentarioProfesionalId ;
   private boolean[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P00823_A40000ComentarioProfesionalId ;
   private boolean[] P00823_n40000ComentarioProfesionalId ;
}

final  class prcvalidarexistecomentario__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00823", "SELECT COALESCE( T1.[ComentarioProfesionalId], 0) AS ComentarioProfesionalId FROM (SELECT MIN([ComentarioProfesionalId]) AS ComentarioProfesionalId FROM [ComentarioProfesional] WHERE ([SGProfesionalProfesionalId] = ?) AND ([SGPacientePacienteId] = ?) AND ([ComentarioProfesionalCitaId] = ?) ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
   }

}

