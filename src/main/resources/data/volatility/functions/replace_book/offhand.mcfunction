advancement revoke @s only volatility:has_book/offhand

data modify storage volatility:item StoredEnchantments set from entity @s Inventory[{Slot:-106b}].tag.StoredEnchantments

function volatility:replace_book/common

execute unless score enchantCount volatility matches 0 run item modify entity @s weapon.offhand volatility:remove_from_book
execute if score enchantCount volatility matches 0 run item replace entity @s weapon.offhand with minecraft:book