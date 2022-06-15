package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prccountrating extends GXProcedure
{
   public prccountrating( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prccountrating.class ), "" );
   }

   public prccountrating( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 )
   {
      prccountrating.this.aP1 = new short[] {0};
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
      prccountrating.this.AV9ProfesionalId = aP0;
      prccountrating.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8TotalRating = (short)(0) ;
      /* Optimized group. */
      /* Using cursor P00892 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9ProfesionalId)});
      cV8TotalRating = P00892_AV8TotalRating[0] ;
      pr_default.close(0);
      AV8TotalRating = (short)(AV8TotalRating+cV8TotalRating*1) ;
      /* End optimized group. */
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = prccountrating.this.AV8TotalRating;
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
      P00892_AV8TotalRating = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prccountrating__default(),
         new Object[] {
             new Object[] {
            P00892_AV8TotalRating
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8TotalRating ;
   private short cV8TotalRating ;
   private short Gx_err ;
   private int AV9ProfesionalId ;
   private String scmdbuf ;
   private short[] aP1 ;
   private IDataStoreProvider pr_default ;
   private short[] P00892_AV8TotalRating ;
}

final  class prccountrating__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00892", "SELECT COUNT(*) FROM [RatingProfesional] WHERE [SGProfesionalProfesionalId] = ? ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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

