advancement revoke @s only volatility:has_unbreaking_book/inventory14

data modify storage volatility:item StoredEnchantments set from entity @s Inventory[{Slot:23b}].tag.StoredEnchantments

function volatility:replace_unbreaking_book/common

execute unless score enchantCount volatility matches 0 run item modify entity @s inventory.14 volatility:remove_from_book
execute if score enchantCount volatility matches 0 run item replace entity @s inventory.14 with minecraft:book