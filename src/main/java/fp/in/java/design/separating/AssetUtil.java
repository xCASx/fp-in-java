package fp.in.java.design.separating;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static fp.in.java.design.separating.Asset.AssetType.BOND;
import static fp.in.java.design.separating.Asset.AssetType.STOCK;

public class AssetUtil {
    static final List<Asset> assets = Arrays.asList(
            new Asset(BOND, 1000),
            new Asset(BOND, 2000),
            new Asset(STOCK, 3000),
            new Asset(STOCK, 4000)
    );

    public static int totalAssetValues(final List<Asset> assets, final Predicate<Asset> assetSelector) {
        return assets.stream()
                     .filter(assetSelector)
                     .mapToInt(Asset::getValue)
                     .sum();
    }

    public static void main(String[] args) {
        System.out.println("Total of all assets: " + AssetUtil.totalAssetValues(assets, asset -> true));
        System.out.println("Total of bonds: " + AssetUtil.totalAssetValues(assets, asset -> asset.getType() == BOND));
        System.out.println("Total of stocks: " + AssetUtil.totalAssetValues(assets, asset -> asset.getType() == STOCK));
    }
}
