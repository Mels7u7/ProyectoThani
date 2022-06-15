package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class dphora30 extends GXProcedure
{
   public dphora30( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( dphora30.class ), "" );
   }

   public dphora30( int remoteHandle ,
                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.projectthani.SdtSDTHora_SDTHoraItem> executeUdp( )
   {
      dphora30.this.aP0 = new GXBaseCollection[] {new GXBaseCollection<com.projectthani.SdtSDTHora_SDTHoraItem>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBaseCollection<com.projectthani.SdtSDTHora_SDTHoraItem>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBaseCollection<com.projectthani.SdtSDTHora_SDTHoraItem>[] aP0 )
   {
      dphora30.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      Gxm1sdthora = (com.projectthani.SdtSDTHora_SDTHoraItem)new com.projectthani.SdtSDTHora_SDTHoraItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1sdthora, 0);
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horaid( "07:00" );
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horavalue( "07:00" );
      Gxm1sdthora = (com.projectthani.SdtSDTHora_SDTHoraItem)new com.projectthani.SdtSDTHora_SDTHoraItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1sdthora, 0);
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horaid( "07:30" );
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horavalue( "07:30" );
      Gxm1sdthora = (com.projectthani.SdtSDTHora_SDTHoraItem)new com.projectthani.SdtSDTHora_SDTHoraItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1sdthora, 0);
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horaid( "08:00" );
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horavalue( "08:00" );
      Gxm1sdthora = (com.projectthani.SdtSDTHora_SDTHoraItem)new com.projectthani.SdtSDTHora_SDTHoraItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1sdthora, 0);
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horaid( "08:30" );
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horavalue( "08:30" );
      Gxm1sdthora = (com.projectthani.SdtSDTHora_SDTHoraItem)new com.projectthani.SdtSDTHora_SDTHoraItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1sdthora, 0);
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horaid( "09:00" );
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horavalue( "09:00" );
      Gxm1sdthora = (com.projectthani.SdtSDTHora_SDTHoraItem)new com.projectthani.SdtSDTHora_SDTHoraItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1sdthora, 0);
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horaid( "09:30" );
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horavalue( "09:30" );
      Gxm1sdthora = (com.projectthani.SdtSDTHora_SDTHoraItem)new com.projectthani.SdtSDTHora_SDTHoraItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1sdthora, 0);
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horaid( "10:00" );
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horavalue( "10:00" );
      Gxm1sdthora = (com.projectthani.SdtSDTHora_SDTHoraItem)new com.projectthani.SdtSDTHora_SDTHoraItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1sdthora, 0);
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horaid( "10:30" );
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horavalue( "10:30" );
      Gxm1sdthora = (com.projectthani.SdtSDTHora_SDTHoraItem)new com.projectthani.SdtSDTHora_SDTHoraItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1sdthora, 0);
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horaid( "11:00" );
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horavalue( "11:00" );
      Gxm1sdthora = (com.projectthani.SdtSDTHora_SDTHoraItem)new com.projectthani.SdtSDTHora_SDTHoraItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1sdthora, 0);
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horaid( "11:30" );
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horavalue( "11:30" );
      Gxm1sdthora = (com.projectthani.SdtSDTHora_SDTHoraItem)new com.projectthani.SdtSDTHora_SDTHoraItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1sdthora, 0);
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horaid( "12:00" );
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horavalue( "12:00" );
      Gxm1sdthora = (com.projectthani.SdtSDTHora_SDTHoraItem)new com.projectthani.SdtSDTHora_SDTHoraItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1sdthora, 0);
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horaid( "12:30" );
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horavalue( "12:30" );
      Gxm1sdthora = (com.projectthani.SdtSDTHora_SDTHoraItem)new com.projectthani.SdtSDTHora_SDTHoraItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1sdthora, 0);
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horaid( "13:00" );
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horavalue( "13:00" );
      Gxm1sdthora = (com.projectthani.SdtSDTHora_SDTHoraItem)new com.projectthani.SdtSDTHora_SDTHoraItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1sdthora, 0);
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horaid( "13:30" );
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horavalue( "13:30" );
      Gxm1sdthora = (com.projectthani.SdtSDTHora_SDTHoraItem)new com.projectthani.SdtSDTHora_SDTHoraItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1sdthora, 0);
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horaid( "14:00" );
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horavalue( "14:00" );
      Gxm1sdthora = (com.projectthani.SdtSDTHora_SDTHoraItem)new com.projectthani.SdtSDTHora_SDTHoraItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1sdthora, 0);
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horaid( "14:30" );
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horavalue( "14:30" );
      Gxm1sdthora = (com.projectthani.SdtSDTHora_SDTHoraItem)new com.projectthani.SdtSDTHora_SDTHoraItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1sdthora, 0);
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horaid( "15:00" );
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horavalue( "15:00" );
      Gxm1sdthora = (com.projectthani.SdtSDTHora_SDTHoraItem)new com.projectthani.SdtSDTHora_SDTHoraItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1sdthora, 0);
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horaid( "15:30" );
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horavalue( "15:30" );
      Gxm1sdthora = (com.projectthani.SdtSDTHora_SDTHoraItem)new com.projectthani.SdtSDTHora_SDTHoraItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1sdthora, 0);
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horaid( "16:00" );
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horavalue( "16:00" );
      Gxm1sdthora = (com.projectthani.SdtSDTHora_SDTHoraItem)new com.projectthani.SdtSDTHora_SDTHoraItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1sdthora, 0);
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horaid( "16:30" );
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horavalue( "16:30" );
      Gxm1sdthora = (com.projectthani.SdtSDTHora_SDTHoraItem)new com.projectthani.SdtSDTHora_SDTHoraItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1sdthora, 0);
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horaid( "17:00" );
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horavalue( "17:00" );
      Gxm1sdthora = (com.projectthani.SdtSDTHora_SDTHoraItem)new com.projectthani.SdtSDTHora_SDTHoraItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1sdthora, 0);
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horaid( "17:30" );
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horavalue( "17:30" );
      Gxm1sdthora = (com.projectthani.SdtSDTHora_SDTHoraItem)new com.projectthani.SdtSDTHora_SDTHoraItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1sdthora, 0);
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horaid( "18:00" );
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horavalue( "18:00" );
      Gxm1sdthora = (com.projectthani.SdtSDTHora_SDTHoraItem)new com.projectthani.SdtSDTHora_SDTHoraItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1sdthora, 0);
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horaid( "18:30" );
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horavalue( "18:30" );
      Gxm1sdthora = (com.projectthani.SdtSDTHora_SDTHoraItem)new com.projectthani.SdtSDTHora_SDTHoraItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1sdthora, 0);
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horaid( "19:00" );
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horavalue( "19:00" );
      Gxm1sdthora = (com.projectthani.SdtSDTHora_SDTHoraItem)new com.projectthani.SdtSDTHora_SDTHoraItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1sdthora, 0);
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horaid( "19:30" );
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horavalue( "19:30" );
      Gxm1sdthora = (com.projectthani.SdtSDTHora_SDTHoraItem)new com.projectthani.SdtSDTHora_SDTHoraItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1sdthora, 0);
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horaid( "20:00" );
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horavalue( "20:00" );
      Gxm1sdthora = (com.projectthani.SdtSDTHora_SDTHoraItem)new com.projectthani.SdtSDTHora_SDTHoraItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1sdthora, 0);
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horaid( "20:30" );
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horavalue( "20:30" );
      Gxm1sdthora = (com.projectthani.SdtSDTHora_SDTHoraItem)new com.projectthani.SdtSDTHora_SDTHoraItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1sdthora, 0);
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horaid( "21:00" );
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horavalue( "21:00" );
      Gxm1sdthora = (com.projectthani.SdtSDTHora_SDTHoraItem)new com.projectthani.SdtSDTHora_SDTHoraItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1sdthora, 0);
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horaid( "21:30" );
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horavalue( "21:30" );
      Gxm1sdthora = (com.projectthani.SdtSDTHora_SDTHoraItem)new com.projectthani.SdtSDTHora_SDTHoraItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1sdthora, 0);
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horaid( "22:00" );
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horavalue( "22:00" );
      Gxm1sdthora = (com.projectthani.SdtSDTHora_SDTHoraItem)new com.projectthani.SdtSDTHora_SDTHoraItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1sdthora, 0);
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horaid( "22:30" );
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horavalue( "22:30" );
      Gxm1sdthora = (com.projectthani.SdtSDTHora_SDTHoraItem)new com.projectthani.SdtSDTHora_SDTHoraItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1sdthora, 0);
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horaid( "23:00" );
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horavalue( "23:00" );
      Gxm1sdthora = (com.projectthani.SdtSDTHora_SDTHoraItem)new com.projectthani.SdtSDTHora_SDTHoraItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1sdthora, 0);
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horaid( "23:30" );
      Gxm1sdthora.setgxTv_SdtSDTHora_SDTHoraItem_Horavalue( "23:30" );
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = dphora30.this.Gxm2rootcol;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      Gxm2rootcol = new GXBaseCollection<com.projectthani.SdtSDTHora_SDTHoraItem>(com.projectthani.SdtSDTHora_SDTHoraItem.class, "SDTHoraItem", "ProjectThani", remoteHandle);
      Gxm1sdthora = new com.projectthani.SdtSDTHora_SDTHoraItem(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private GXBaseCollection<com.projectthani.SdtSDTHora_SDTHoraItem>[] aP0 ;
   private GXBaseCollection<com.projectthani.SdtSDTHora_SDTHoraItem> Gxm2rootcol ;
   private com.projectthani.SdtSDTHora_SDTHoraItem Gxm1sdthora ;
}

