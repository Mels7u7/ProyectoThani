package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcreprogramarcita extends GXProcedure
{
   public prcreprogramarcita( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcreprogramarcita.class ), "" );
   }

   public prcreprogramarcita( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              int aP1 )
   {
      prcreprogramarcita.this.aP2 = new boolean[] {false};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        int aP1 ,
                        boolean[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             int aP1 ,
                             boolean[] aP2 )
   {
      prcreprogramarcita.this.AV11CitaId = aP0;
      prcreprogramarcita.this.AV8DisponibilidadId = aP1;
      prcreprogramarcita.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9isSuccess = false ;
      AV10Cita.Load(AV11CitaId);
      AV10Cita.setgxTv_SdtCita_Sgcitadisponibilidadid( AV8DisponibilidadId );
      AV10Cita.Save();
      if ( AV10Cita.Success() )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "prcreprogramarcita");
         AV9isSuccess = true ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "prcreprogramarcita");
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = prcreprogramarcita.this.AV9isSuccess;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10Cita = new com.projectthani.SdtCita(remoteHandle);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcreprogramarcita__default(),
         new Object[] {
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV11CitaId ;
   private int AV8DisponibilidadId ;
   private boolean AV9isSuccess ;
   private boolean[] aP2 ;
   private IDataStoreProvider pr_default ;
   private com.projectthani.SdtCita AV10Cita ;
}

final  class prcreprogramarcita__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
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
      }
   }

}

