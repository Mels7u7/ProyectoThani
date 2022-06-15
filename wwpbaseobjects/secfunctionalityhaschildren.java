package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class secfunctionalityhaschildren extends GXProcedure
{
   public secfunctionalityhaschildren( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( secfunctionalityhaschildren.class ), "" );
   }

   public secfunctionalityhaschildren( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( long aP0 )
   {
      secfunctionalityhaschildren.this.aP1 = new boolean[] {false};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( long aP0 ,
                        boolean[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( long aP0 ,
                             boolean[] aP1 )
   {
      secfunctionalityhaschildren.this.AV9SecFunctionalityId = aP0;
      secfunctionalityhaschildren.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8HasChildren = false ;
      /* Using cursor P001W2 */
      pr_default.execute(0, new Object[] {Long.valueOf(AV9SecFunctionalityId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2SecParentFunctionalityId = P001W2_A2SecParentFunctionalityId[0] ;
         n2SecParentFunctionalityId = P001W2_n2SecParentFunctionalityId[0] ;
         A1SecFunctionalityId = P001W2_A1SecFunctionalityId[0] ;
         AV8HasChildren = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = secfunctionalityhaschildren.this.AV8HasChildren;
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
      P001W2_A2SecParentFunctionalityId = new long[1] ;
      P001W2_n2SecParentFunctionalityId = new boolean[] {false} ;
      P001W2_A1SecFunctionalityId = new long[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wwpbaseobjects.secfunctionalityhaschildren__default(),
         new Object[] {
             new Object[] {
            P001W2_A2SecParentFunctionalityId, P001W2_n2SecParentFunctionalityId, P001W2_A1SecFunctionalityId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private long AV9SecFunctionalityId ;
   private long A2SecParentFunctionalityId ;
   private long A1SecFunctionalityId ;
   private String scmdbuf ;
   private boolean AV8HasChildren ;
   private boolean n2SecParentFunctionalityId ;
   private boolean[] aP1 ;
   private IDataStoreProvider pr_default ;
   private long[] P001W2_A2SecParentFunctionalityId ;
   private boolean[] P001W2_n2SecParentFunctionalityId ;
   private long[] P001W2_A1SecFunctionalityId ;
}

final  class secfunctionalityhaschildren__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P001W2", "SELECT TOP 1 [SecParentFunctionalityId], [SecFunctionalityId] FROM [SecFunctionality] WHERE [SecParentFunctionalityId] = ? ORDER BY [SecParentFunctionalityId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((long[]) buf[2])[0] = rslt.getLong(2);
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
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
      }
   }

}

