package net.hollowed.volatility.common.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.Mod;

import static net.hollowed.volatility.Volatility.MOD_ID;

// You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientSetupEvents {

	public static void modRenderTypes() {
		//EntityRenderers.register(ModEntityTypes.ICEOLOGER.get(), IceologerRenderer::new);
		//EntityRenderers.register(ModEntityTypes.ICE_CHUNK.get(), IceChunkRenderer::new);
		//EntityRenderers.register(ModEntityTypes.ICE_SPIKES.get(), IceSpikesRenderer::new);


		// ItemBlockRenderTypes.setRenderLayer(ModBlocks.TEMPLE_STATUE.get(), RenderType.cutout());
		// ItemBlockRenderTypes.setRenderLayer(ModBlocks.CATTAIL.get(), renderType -> renderType == RenderType.cutout());

		//BlockEntityRenderers.register(ModBlockEntities.MOD_SIGN_BLOCK_ENTITIES.get(), SignRenderer::new);
	}

	public static void modWoodTypes() {

		//WoodType.register(ModWoodTypes.CINNAMON);
		//WoodType.register(ModWoodTypes.MAHOGANY);

	}


//	@SubscribeEvent
//	public static void onClientSetup(FMLClientSetupEvent event) {
//		EntityRenderers.register(ModEntityTypes.WROUGHT_SPEARMAN.get(), WroughtSpearmanRenderer::new);
//		EntityRenderers.register(ModEntityTypes.WROUGHT_SWORDSMAN.get(), WroughtSwordsmanRenderer::new);
//		EntityRenderers.register(ModEntityTypes.DEEPSLATE_GOLEM.get(), DeepslateGolemRenderer::new);
//		EntityRenderers.register(ModEntityTypes.WROUGHT_SENTINEL.get(), WroughtSentinelRenderer::new);
//		EntityRenderers.register(ModEntityTypes.SHOCKWAVE.get(), WroughtSentinelRenderer::new);
//
//		ItemBlockRenderTypes.setRenderLayer(ModBlocks.TEMPLE_STATUE.get(), RenderType.cutout());
//		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CATTAIL.get(), renderType -> renderType == RenderType.cutout());
//	}

}
