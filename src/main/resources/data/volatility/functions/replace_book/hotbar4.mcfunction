advancement revoke @s only volatility:has_book/hotbar4

data modify storage volatility:item StoredEnchantments set from entity @s Inventory[{Slot:4b}].tag.StoredEnchantments

function volatility:replace_book/common

execute unless score enchantCount volatility matches 0 run item modify entity @s hotbar.4 volatility:remove_from_book
execute if score enchantCount volatility matches 0 run item replace entity @s hotbar.4 with minecraft:book