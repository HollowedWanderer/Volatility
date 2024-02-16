advancement revoke @s only volatility:has_book/hotbar3

data modify storage volatility:item StoredEnchantments set from entity @s Inventory[{Slot:3b}].tag.StoredEnchantments

function volatility:replace_book/common

execute unless score enchantCount volatility matches 0 run item modify entity @s hotbar.3 volatility:remove_from_book
execute if score enchantCount volatility matches 0 run item replace entity @s hotbar.3 with minecraft:book