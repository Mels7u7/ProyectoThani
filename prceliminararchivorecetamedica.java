package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prceliminararchivorecetamedica extends GXProcedure
{
   public prceliminararchivorecetamedica( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prceliminararchivorecetamedica.class ), "" );
   }

   public prceliminararchivorecetamedica( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( int aP0 )
   {
      prceliminararchivorecetamedica.this.AV8CitaId = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Optimized DELETE. */
      /* Using cursor P007E2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CitaId)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("RecetaMedica");
      /* End optimized DELETE. */
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "prceliminararchivorecetamedica");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prceliminararchivorecetamedica__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CitaId ;
   private IDataStoreProvider pr_default ;
}

final  class prceliminararchivorecetamedica__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P007E2", "DELETE FROM [RecetaMedica]  WHERE ([CitaId] = ?) AND ([RecetaMedicaFlag] = 0)", GX_NOMASK + GX_MASKLOOPLOCK)
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
               return;
      }
   }

}

