data remove storage volatility:item StoredEnchantments[{id:"minecraft:unbreaking"}]

scoreboard players set enchantCount volatility 0
execute store result score enchantCount volatility run data get storage volatility:item StoredEnchantments 