package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prccountcomentario extends GXProcedure
{
   public prccountcomentario( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prccountcomentario.class ), "" );
   }

   public prccountcomentario( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 )
   {
      prccountcomentario.this.aP1 = new short[] {0};
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
      prccountcomentario.this.AV8ProfesionalId = aP0;
      prccountcomentario.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9TotalComentario = (short)(0) ;
      /* Optimized group. */
      /* Using cursor P008A2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8ProfesionalId)});
      cV9TotalComentario = P008A2_AV9TotalComentario[0] ;
      pr_default.close(0);
      AV9TotalComentario = (short)(AV9TotalComentario+cV9TotalComentario*1) ;
      /* End optimized group. */
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = prccountcomentario.this.AV9TotalComentario;
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
      P008A2_AV9TotalComentario = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prccountcomentario__default(),
         new Object[] {
             new Object[] {
            P008A2_AV9TotalComentario
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9TotalComentario ;
   private short cV9TotalComentario ;
   private short Gx_err ;
   private int AV8ProfesionalId ;
   private String scmdbuf ;
   private short[] aP1 ;
   private IDataStoreProvider pr_default ;
   private short[] P008A2_AV9TotalComentario ;
}

final  class prccountcomentario__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P008A2", "SELECT COUNT(*) FROM [ComentarioProfesional] WHERE [SGProfesionalProfesionalId] = ? ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
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
      }
   }

}

