advancement revoke @s only volatility:has_book/inventory6

data modify storage volatility:item StoredEnchantments set from entity @s Inventory[{Slot:15b}].tag.StoredEnchantments

function volatility:replace_book/common

execute unless score enchantCount volatility matches 0 run item modify entity @s inventory.6 volatility:remove_from_book
execute if score enchantCount volatility matches 0 run item replace entity @s inventory.6 with minecraft:book