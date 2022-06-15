package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcguardarinformecita extends GXProcedure
{
   public prcguardarinformecita( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcguardarinformecita.class ), "" );
   }

   public prcguardarinformecita( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( com.projectthani.SdtSDTCitaData aP0 ,
                              String[] aP1 )
   {
      prcguardarinformecita.this.aP2 = new boolean[] {false};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( com.projectthani.SdtSDTCitaData aP0 ,
                        String[] aP1 ,
                        boolean[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( com.projectthani.SdtSDTCitaData aP0 ,
                             String[] aP1 ,
                             boolean[] aP2 )
   {
      prcguardarinformecita.this.AV8SDTCitaData = aP0;
      prcguardarinformecita.this.aP1 = aP1;
      prcguardarinformecita.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV10Cita.Load(AV8SDTCitaData.getgxTv_SdtSDTCitaData_Citaid());
      AV10Cita.setgxTv_SdtCita_Citaantecedentes( AV8SDTCitaData.getgxTv_SdtSDTCitaData_Citaantecedentes() );
      AV10Cita.setgxTv_SdtCita_Citainforme( AV8SDTCitaData.getgxTv_SdtSDTCitaData_Citainforme() );
      AV10Cita.setgxTv_SdtCita_Citatipodiagnostico( AV8SDTCitaData.getgxTv_SdtSDTCitaData_Citatipodiagnostico() );
      AV10Cita.setgxTv_SdtCita_Citaestadocita( AV8SDTCitaData.getgxTv_SdtSDTCitaData_Citaestadocita() );
      AV10Cita.Save();
      if ( AV10Cita.Success() )
      {
         AV11isSaved = true ;
         AV9ErrorMessage = "Se guardó satisfactoriamente." ;
         Application.commitDataStores(context, remoteHandle, pr_default, "prcguardarinformecita");
      }
      else
      {
         AV11isSaved = false ;
         AV9ErrorMessage = "Hubo un error no se pudo guardar." ;
         Application.rollbackDataStores(context, remoteHandle, pr_default, "prcguardarinformecita");
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = prcguardarinformecita.this.AV9ErrorMessage;
      this.aP2[0] = prcguardarinformecita.this.AV11isSaved;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9ErrorMessage = "" ;
      AV10Cita = new com.projectthani.SdtCita(remoteHandle);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcguardarinformecita__default(),
         new Object[] {
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private boolean AV11isSaved ;
   private String AV9ErrorMessage ;
   private boolean[] aP2 ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private com.projectthani.SdtSDTCitaData AV8SDTCitaData ;
   private com.projectthani.SdtCita AV10Cita ;
}

final  class prcguardarinformecita__default extends DataStoreHelperBase implements ILocalDataStoreHelper
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

