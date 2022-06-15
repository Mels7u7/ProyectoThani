package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prceliminardiagnostico extends GXProcedure
{
   public prceliminardiagnostico( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prceliminardiagnostico.class ), "" );
   }

   public prceliminardiagnostico( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        int aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             int aP1 )
   {
      prceliminardiagnostico.this.AV9CitaId = aP0;
      prceliminardiagnostico.this.AV8DiagnosticoId = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Optimized DELETE. */
      /* Using cursor P006F2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CitaId), Integer.valueOf(AV8DiagnosticoId)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("CitaDiagnostico");
      /* End optimized DELETE. */
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "prceliminardiagnostico");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prceliminardiagnostico__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9CitaId ;
   private int AV8DiagnosticoId ;
   private IDataStoreProvider pr_default ;
}

final  class prceliminardiagnostico__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P006F2", "DELETE FROM [CitaDiagnostico]  WHERE ([CitaId] = ?) AND ([DiagnosticoId] = ?)", GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
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
               return;
      }
   }

}

